/*
 * Copyright (c) 2019 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jagex.runescape.gpu;

import com.runescape.Client;
import com.runescape.media.Rasterizer3D;
import com.runescape.media.renderable.actor.Player;
import com.runescape.util.Signlink;

import java.io.FileInputStream;

public class SkyboxPlugin {

	private Skybox skybox;

	public SkyboxPlugin() throws Exception {
		final String name = "skybox.txt";
		skybox = new Skybox(new FileInputStream(Signlink.findcachedir() + "gl/" + name), name);
	}

	private int mapChunk(int cx, int cy, final int plane) {
		cx -= Client.instance.getBaseX() / 8;
		cy -= Client.instance.getBaseY() / 8;
		final int[][] instanceTemplateChunks = Client.instance.dynamicRegionData[plane];
		// Blending can access this out of bounds, so do a range check
		if (cx < 0 || cx >= instanceTemplateChunks.length || cy < 0 || cy >= instanceTemplateChunks[cx].length) {
			return -1;
		}
		return instanceTemplateChunks[cx][cy];
	}

	public void onBeforeRender() {
		if (skybox == null || !Client.instance.loggedIn) {
			return;
		}
		final Player player = Client.myPlayer;
		if (player == null) {
			return;
		}
		final int px;
		final int py;
		px = player.x;
		py = player.y;
		// Inverse of camera location / 2
		final int spx = -((Client.instance.getCameraX2() - px) >> 1);
		final int spy = -((Client.instance.getCameraY2() - py) >> 1);
		final int baseX = Client.instance.getBaseX();
		final int baseY = Client.instance.getBaseY();
		Client.instance.setSkyboxColor(skybox.getColorForPoint(
				baseX + ((px + spx) / 128.f),
				baseY + ((py + spy) / 128.f),
				baseX + (px / 128),
				baseY + (py / 128),
				Client.instance.getPlane(),
				//((TextureProvider) Canvas3D.textureInterface).getBrightness(),
				Rasterizer3D.brightness,
				Client.instance.dynamicRegion ? this::mapChunk : null
		));
	}
}
