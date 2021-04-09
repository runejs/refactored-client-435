package com.jagex.runescape.frame.tab.parts;

import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.input.MouseHandler;

import java.util.Base64;

public class TabParts {
    private static ImageRGB combat;
    private static ImageRGB emotes;
    private static ImageRGB equipment;
    private static ImageRGB friends;
    private static ImageRGB ignores;
    private static ImageRGB inventory;
    private static ImageRGB large_left_right;
    private static ImageRGB large_left_right_hovered;
    private static ImageRGB large_left_right_selected;
    private static ImageRGB large_middle;
    private static ImageRGB large_middle_hovered;
    private static ImageRGB large_middle_selected;
    private static ImageRGB logout;
    private static ImageRGB logout_small;
    private static ImageRGB magic;
    private static ImageRGB medium_left_right;
    private static ImageRGB medium_left_right_hovered;
    private static ImageRGB medium_left_right_selected;
    private static ImageRGB medium_middle;
    private static ImageRGB medium_middle_hovered;
    private static ImageRGB medium_middle_selected;
    private static ImageRGB music;
    private static ImageRGB options;
    private static ImageRGB prayer;
    private static ImageRGB quests;
    private static ImageRGB side_border_bottom;
    private static ImageRGB side_border_bottom_selected;
    private static ImageRGB side_border_edge_bottom_left;
    private static ImageRGB side_border_edge_bottom_left_selected;
    private static ImageRGB side_border_edge_bottom_right;
    private static ImageRGB side_border_edge_bottom_right_selected;
    private static ImageRGB side_border_edge_top_left;
    private static ImageRGB side_border_edge_top_left_selected;
    private static ImageRGB side_border_edge_top_right;
    private static ImageRGB side_border_edge_top_right_selected;
    private static ImageRGB side_border_left;
    private static ImageRGB side_border_left_selected;
    private static ImageRGB side_border_middle;
    private static ImageRGB side_border_right;
    private static ImageRGB side_border_right_selected;
    private static ImageRGB side_border_top;
    private static ImageRGB side_border_top_selected;
    private static ImageRGB small_left_right;
    private static ImageRGB small_left_right_hovered;
    private static ImageRGB small_left_right_selected;
    private static ImageRGB small_middle;
    private static ImageRGB small_middle_hovered;
    private static ImageRGB small_middle_selected;
    private static ImageRGB stats;
    private static ImageRGB stone_bottom_left_selected;
    private static ImageRGB stone_bottom_right_selected;
    private static ImageRGB stone_middle_selected;
    private static ImageRGB stone_top_left_selected;
    private static ImageRGB stone_top_right_selected;
    private static ImageRGB side_panel_background;
    private static ImageRGB side_panel_edge_left;
    private static ImageRGB side_panel_edge_right;
    private static ImageRGB tabs_bottom_row;
    private static ImageRGB tab_stone_middle;
    private static ImageRGB tab_stone_middle_selected;
    private static ImageRGB tabs_top_row;
    private static boolean setup = false;

    public static ImageRGB GetPart(String part) {
        if(!TabParts.setup) {
            TabParts.CreateParts();
        }
        switch(part) {
            case "combat":
                return combat;
            case "emotes":
                return emotes;
            case "equipment":
                return equipment;
            case "friends":
                return friends;
            case "ignores":
                return ignores;
            case "inventory":
                return inventory;
            case "large_left_right":
                return large_left_right;
            case "large_left_right_hovered":
                return large_left_right_hovered;
            case "large_left_right_selected":
                return large_left_right_selected;
            case "large_middle":
                return large_middle;
            case "large_middle_hovered":
                return large_middle_hovered;
            case "large_middle_selected":
                return large_middle_selected;
            case "logout":
                return logout;
            case "logout_small":
                return logout_small;
            case "magic":
                return magic;
            case "medium_left_right":
                return medium_left_right;
            case "medium_left_right_hovered":
                return medium_left_right_hovered;
            case "medium_left_right_selected":
                return medium_left_right_selected;
            case "medium_middle":
                return medium_middle;
            case "medium_middle_hovered":
                return medium_middle_hovered;
            case "medium_middle_selected":
                return medium_middle_selected;
            case "music":
                return music;
            case "options":
                return options;
            case "prayer":
                return prayer;
            case "quests":
                return quests;
            case "side_border_bottom":
                return side_border_bottom;
            case "side_border_bottom_selected":
                return side_border_bottom_selected;
            case "side_border_edge_bottom_left":
                return side_border_edge_bottom_left;
            case "side_border_edge_bottom_left_selected":
                return side_border_edge_bottom_left_selected;
            case "side_border_edge_bottom_right":
                return side_border_edge_bottom_right;
            case "side_border_edge_bottom_right_selected":
                return side_border_edge_bottom_right_selected;
            case "side_border_edge_top_left":
                return side_border_edge_top_left;
            case "side_border_edge_top_left_selected":
                return side_border_edge_top_left_selected;
            case "side_border_edge_top_right":
                return side_border_edge_top_right;
            case "side_border_edge_top_right_selected":
                return side_border_edge_top_right_selected;
            case "side_border_left":
                return side_border_left;
            case "side_border_left_selected":
                return side_border_left_selected;
            case "side_border_middle":
                return side_border_middle;
            case "side_border_right":
                return side_border_right;
            case "side_border_right_selected":
                return side_border_right_selected;
            case "side_border_top":
                return side_border_top;
            case "side_border_top_selected":
                return side_border_top_selected;
            case "small_left_right":
                return small_left_right;
            case "small_left_right_hovered":
                return small_left_right_hovered;
            case "small_left_right_selected":
                return small_left_right_selected;
            case "small_middle":
                return small_middle;
            case "small_middle_hovered":
                return small_middle_hovered;
            case "small_middle_selected":
                return small_middle_selected;
            case "stats":
                return stats;
            case "stone_bottom_left_selected":
                return stone_bottom_left_selected;
            case "stone_bottom_right_selected":
                return stone_bottom_right_selected;
            case "stone_middle_selected":
                return stone_middle_selected;
            case "stone_top_left_selected":
                return stone_top_left_selected;
            case "stone_top_right_selected":
                return stone_top_right_selected;
            case "side_panel_background":
                return side_panel_background;
            case "side_panel_edge_left":
                return side_panel_edge_left;
            case "side_panel_edge_right":
                return side_panel_edge_right;
            case "tabs_bottom_row":
                return tabs_bottom_row;
            case "tab_stone_middle":
                return tab_stone_middle;
            case "tab_stone_middle_selected":
                return tab_stone_middle_selected;
            case "tabs_top_row":
                return tabs_top_row;

        }
        return side_panel_background;
    }

    private static void CreateParts() {
        String combat = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABnElEQVR42mNgGAWjYBSMAooA439UTC+9aAb9evny/8dvr8GYeMMY4XpA+kF8GRmZ/xQ54tzTC3DHEHYII9xymD6KHfHu7vf/d+6++X/69DmwgZ+enMfjEEawPEgdSD1IH0g/hY5AOARkKAiDLMHuEEa43LXzWzEcQKEjIBbAQuPglllYQgTiAFDwg+RBNEg9FR2A3SEg9veXm8EWgWgQf8uCRng00MABqA7Zvv8U2CEgC2AOWNKfQw8HIBxyauMbuANAQd9XlwZ2AEicDg6AAJAFt84tBzugPS/0/4rVW8EOsFASpI8DQD4FOQDk87IMr/9z5k6Bh4ybrQmlpSNxxS+yAyb1daM4ACQOS6xUKrIRjng+Wen/32vhYAtAFiUE2WA4ICO9BhwdMIeA1IP0UaGgwnQIyEKQA+ateI9kAeP/9qkf/zf0tIPl0R1A1XIC5hCQhZgWQHINTR1Q5SHxH9khmMHMiOIAmHqqOwAW9NjjGl2cag5BdQBy0GNzBDZ1VHAII864JVYMu4PJKB0pTVx0KkVHwSgYBcMYAADdJysFGr8x4wAAAABJRU5ErkJggg==";
        String emotes = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABSklEQVR42u2XvwrCMBDGvc3BP+igKJ0cdHAUQfQBuguKjyAIOvoIbm4+R1/EV/EZIpdwTWKbUsW7Lg18kGrgfvflck0bjXrU4+sBqtyaMut+BHglF1UcBFQ866rVpMcFAiq5bzXI83EKBAF1O++0cB5FEQ8IAiBMfhDjFjnGBGEdyXfDQNJ/jBB5IFbHeK7l/84IgntPmVNw9/m6X2iJgKArKAJBHTZjLZxToTL3DgODWeeBuHXChmEKEDIQVBsIKHBijCNUB35x+o1O5MRgt0QQ3AYbVAzCB7Gt2yjc4P4MQO8NV58usEMM16NUrWVftTud1AkxAAzsAuBcCMCHwDkBuBCiAHQaKoHI2g5SEKGMQbIeKnehKFjlW2HfrCJb4Z6IEITAN0goW1DTQZP/IkNBwtmygUDmYlsEwXbZJftdlV1bf0bX45fxBqXhghn0WzVOAAAAAElFTkSuQmCC";
        String equipment = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABiElEQVR42u2WPU5CQRDH2Xu8Y9BKYmO8gIUHsMJAoaUFHYWJhdEOEnoLExJOgdGOW3CGJf/d/GH2uQubx34UusmEx37Nb2dmZ6fX+29JmtJWKgKs19968jisBaL08mNhAC4H17VAlFE8Hd0YAQj6mqbRxS2x/RwbeXga1YCwIF/vQyMESAgRivjf/XADxAWIXx8EoIkPi6xsflZG8H110ddtS7APc+Cq9np330gTM/r5//7uVs/mb0agEGNS0MdxuQ7f2Kvtukh3uAIlAIHgmyemEIzjoX2iY4cTpciNcBvoHkIccoWrzL/XGY0wOK1UTgu0lWe/nrDG68vzPgYyXNPuEMVfTwSgDMKiVoDAArCEjIdCj5hNRswJEoLXtgCIhWBykokKv4TI7BYXQsZGUQj/lbT1BcaqQMgipyiEPzGpchDHM2P2fGGDkqcNWSnzNVX7esF/2lPjCSvsUxCZ3xEV8Vqq/BBMUGEFMXOS54fjLssCEAuRGKRLoeorcM9sXQrV5MXtn2k7OJBW4xG8NZ8AAAAASUVORK5CYII=";
        String friends = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABT0lEQVR42u2XQW7CMBBFHXEFllEX3KBixxl6Eq7BCRArztAl9AZsWPUKlYqEumWDukBG39HQH2NbOJmwqDzSVyQ7nnn5GieOMSVKlPhfUdm0nlB8uxzb42py0/d6ZL8Wxu7mxr6/mSFh/opf9q83/X68OAFE1IZRBuDiIRAGgjOKIA0AkscgfBBxRAnkMYAYCCAUQCrXAwwhRXLcQI8gV13XNhsAi7korqfDp1MIhOcZoocblVvMTycFoPPP5s4hnoMYoqMbTT8gEUNgfDadRCF4XgUCC0MQEEPE5geBeFR+P6hA5IKoQyBBDkQIoBcEtpUkQWKMhYD4uyGS3eVv0c7vihBITLjPB2AXOkGwGyLZAb71Mu7f38OFNAgXjRX3AXpApEFSUgRog3CPxMSHGkWA9vFOYELi490AAE00SdMHXSk+CIAPk1L5IylRQiuuPsKrBoEmrIcAAAAASUVORK5CYII=";
        String ignores = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABMElEQVR42u2XMQ6CQBBFNR6AxMTYUJnoBewsPZ/XseESbGVh7QmstEKHdfCzzmxEBk3MTvILdoD/9i9kYTRKlSrVf9W4iusL5sVsUh3nWSM6Ju0yrwFhnubX7arRZTmtRePu3ncvMMYAaC6BsBwkYwTiAejmGoSWihHI+wBhIgxhADKuZ4UQvO4aBPelNPI8rzoD0MU8MwY4n8paEgT2GaZnGm0INCAdyr0KwH0JomMaHoKXg01ofLNeqBDYN4NwjwcTTUgIofXNIboIH0ozCF6Sn0EUs25pSAAmEAW8+5hKuHvi/mEEIYOQ0BSNcZfVAD6GQBAacwAkzToE6ZGCnIY00xhEzxR0kHdlCKAvTcx8AID25x2baOLzBgDw5W8a/9Bl80EAQpiY0h9JqlRWdQNLWwBds+JSNAAAAABJRU5ErkJggg==";
        String inventory = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABlElEQVR42u3XMU7EMBAF0KSjCwgJUaTagr0CnAB6rkBFQ88FOAAH4RLchYozBE2sv/4ZjR3bTISEYmm0y7Lxfxk72d2u28c+XEc/WXU+DNNmkTdXZ4ug14frud4ej6fCaxHlfMYItMItSMQ4AKQD98chG2wBnCABcHu4mEsgtQAHSOxCrhs6EGh+7enusgXSzwciXCa1IAjRHZNj5bk8AtEACQhMaEF04X8ohjBiHMepGIBJSiHcOdTX+2H6fO5OHalGWC1miNUNHPf98TID5G95RKcKEXEZrKsjB8HZCoDfLwgGFCPiBuqTCEAQjgKCO4GTKl4KHKARa93APhAELwegy3lXEDL5GoIhCJcwFF8hGlG0HDmEBdHBeM4AdMoNwRBeBsA0gperGJHbExYiddP6NQLdsAAphL6NM6ByTyyXpBWh7x8NiPhFpgSR+xi3PjcqEOn9sLYndDh3oBLQhuBwB0Aewpdk6uydAOn9wYhUuCMgjDBRn0Skwt0AGoJ7CVf4wbNheA6z+ZmXYP4sfB//evwApnRXpXr5AIEAAAAASUVORK5CYII=";
        String large_left_right = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAaCAYAAAC3g3x9AAAAOUlEQVR42mNgQAKxER7/KcUYhmmoylGEqWoYioHUMAxsIDVdBzeQWoaNGjhq4KiBowaOGjhqIDUxAJm3+gklK4xLAAAAAElFTkSuQmCC";
        String large_left_right_hovered = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAaCAYAAAC3g3x9AAAAOUlEQVR42mNgQAKxER7/KcUYhvl42FCEqWoYioHUMAxsIDVdBzeQWoaNGjhq4KiBowaOGjhqIDUxAN/Vqz2QIb7/AAAAAElFTkSuQmCC";
        String large_left_right_selected = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAaCAYAAAC3g3x9AAAAOklEQVR42mNgQAKxER7/KcUYhtmZalKEqWoYioHUMAxsIDVdBzeQWoaNGjhq4KiBowaOGjhqIDUNBAAHT0jWOfZUWwAAAABJRU5ErkJggg==";
        String large_middle = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAaCAYAAAC3g3x9AAAAK0lEQVR42mOIjfD4T03MoKEq95+aeNTAUQNHDRw1cNTAUQNHDSTfQGpX9ACllvY/fCEwcwAAAABJRU5ErkJggg==";
        String large_middle_hovered = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAaCAYAAAC3g3x9AAAAK0lEQVR42mOIjfD4T03M4ONh85+aeNTAUQNHDRw1cNTAUQNHDSTfQGpX9AAxGrOuqsjDFAAAAABJRU5ErkJggg==";
        String large_middle_selected = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAaCAYAAAC3g3x9AAAAKUlEQVR42mOIjfD4T03MYGeq+Z+aeNTAUQNHDRw1cNTAUQNHDRw8BgIAr+lKmjcRNUUAAAAASUVORK5CYII=";
        String logout = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABnklEQVR42u2XsUpDMRSGmycoro4uHQQXHQRx6NKK4KIoujpIB3ESdRKcOghXECep0KHg4CBIXVzUF9BNwVdwcnGNfJETIh16m5NLqTTwc0PuPcnHPf9JSKk0bqPdjO2vghd/e733+ni59grHC4IxftHm3rp97l7ar+/PHjHOe76jnxDEuAlDZcc7ttap9igEECUAMbbbPnGLPj3s2/fHllPnbNeN0ZfFAGBcIIg7aCzb1tWFBsT8yf381IRTvVLuK/lW4oGNBDHedEzCpEdLM06N+rRtrlXc83Bj1o9LnyffS6wiLb9eYBJSEQMhqSI1ow1BMLrNVqMgMKqYWGVOJkAxEFQMFZK0OgaF+F/VgTTGvLtp66tDC5GsOnB4Hgh+P5WUvDpwOMoDAcDmwqSHoDKGXh2hsaPTQbCcijEQcupiTrUx8UUMBIsjxXGeDuI8O42HCN0dAyFbPsZWmVMcHgOxvbXipALQbttiTNW2Hbpbs2OqqiM01tCMqYWgNJEKQtyNMWuLcwMrjFeZM5T8mTwq8H6a5zJc+KV43IptP22ivDpBuetcAAAAAElFTkSuQmCC";
        String logout_small = "iVBORw0KGgoAAAANSUhEUgAAABUAAAAeCAYAAADD0FVVAAABA0lEQVR42mNgwAGYmJn/E8IMxAKYhhdPjsHx4e3z4BhZnCjDYYaBNBemxYDpD6/eYWBkeRDGaTBIAtlFIDy7M/6/yyRXDIxsIE6DQQJ7VhSCDQHRyIaCMLJmkIHIYiD1ILFJKyYiDEYOP5Aidw0hkjGyfrDB6N4GKarw1ycag9RjBAOyoSCvUGIoSD9tDQVxYJgcQ2ERCsIokQUTJMdQUOyDMN7YJ9XQ0djHHfvERhTMAIKxD4tBYgxF9hHNYh9vRA3K2IcXfzQzFDn2KMn7GJFFSuwTlfdpGlE0MRQU0FSPfXINBemDYYzYBwW2sY49yRhn7CNj9IYCPkx0+4qYxhk+QwBstMbkSdB5VQAAAABJRU5ErkJggg==";
        String magic = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABnUlEQVR42u3WsUrDUBTG8fYJxFU6uTgILnZQ1NWK4FJQdBMHKVScRJ1EXdz6AMXBJ9Clu/gUPs6Vf8OXnNykpUlvG5Bc+Gibtuf+cu5tk0ajHvWoR/DRdEkqAvyMhq7X2XTne2uuAlAasLO+6i67+3GWgJkOuLo4ycEE7VIEeLs9zQAezrZTGIXP8N7g6XqcOSEJgC50NlZSE9sO+CAgfIdQp9VqudKA57t+BnDfO3afr7txeG0DmgAhJREJgGIAdIYWMLxpx7EALYP2CICCiDSAfeAD7OSEY3xWjwJQp0QXJgN0tnbyr0F3KuD3+70oIg1gH9gO2Gg5QGj97RIIMPp4iTfmzAjtZgFUXBNNCqA8AM8PD9pFutF0j0db49hl8CfTc7qgs58FUAgBgCIUI8LYCf0EAkQIfoqEIhTLw9glU/gvCABILtEUpBsUy8PwPsvBBtZ+4VgAQPZegWJqs4+xEHUiECAa0ZcTyCSM/pKDA8pgFgYoguGiNueVshyGSZncBywc4WO0Iee4VIe9615qF/K6UimgHvX4t+MPoxsITvo450wAAAAASUVORK5CYII=";
        String medium_left_right = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAfUlEQVR42r3UPQrAIAwF4NzFvTjasUMv0NH738NOBRuj+UXhTYaPJ4oA3So5NW8G7CoHnzP/0+3pMAwRsK8Z0RLE2AxEM+BqR8zpGgrCg4JWMpC7UdWRJdjsHQ6gFkPZADrRTaADXb/DcNCAQshPYwI/lMFtn8MKrM/dIvMCQIuuM1KbyjwAAAAASUVORK5CYII=";
        String medium_left_right_hovered = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAN0lEQVR42mNgQAI1BbH/KcUYhkUHe1KEqWoY2EBqGgY3kFqGjRo4auCogaMGDmUDo4Jc/1MTAwDccTgIWRF8KwAAAABJRU5ErkJggg==";
        String medium_left_right_selected = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAU0lEQVR42mNgQAKxER7/KcUYhnnYGWNiBxOiMWHDSDWQmobBDcRpGLkuHOIGUi0MSTQIv4FkGobdQAoMGzWQVpFCEwOpng4pMJSOWY+mpQ0JhgIA5ibVYYqu/WMAAAAASUVORK5CYII=";
        String medium_middle = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAUElEQVR42mOwMFD+T03M4Gih958kbGmAitHkSTcQ2VAscuQZiAePGjgoDcSTBCgzEBumuoFkGErYQBINHk4GEmnoSDIQqob6BkYFuf6nJgYAXTi5X6IxcpYAAAAASUVORK5CYII=";
        String medium_middle_hovered = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAMUlEQVR42mOoKYj9T03MEB3s+Z8aOCrIFYxHDRw1cCANhOFRA0cNHDWQKANheZBaGAD2lz1WVjMVfwAAAABJRU5ErkJggg==";
        String medium_middle_selected = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAcElEQVR42mOIjfD4T03M4OFg8h+M7YxxY5gabBiqxtHSAIwZsEmSYyAME+dCXIZiUUe8gdgMxWsgqa7EoYY0A4nADMQGNuUGkmkofgPJMJSwgSQaSpyBJBhMmoFEGDxIDCQ6YVPBcOoYiIRHDaQcAwC3z9n+PjjbeQAAAABJRU5ErkJggg==";
        String music = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABNUlEQVR42u2XMQ6CMBSGyxl0MMruAZyMF3A3MR7A0d3EjcnRuDk6eAQu4k28AaYlD96j76GBthjTl7wAofB//f+EFqVixfrvSgq+A4qf1hPS583ctCMQaUZUfL8cmWt9BABHILVI/SJeXHeapuaIAeDZ8l4HAC2ALZbEX8+ZEamFkgqgB0RSWYvPofHMdQME5yCM7wSR37PicTkQm7F4Uzi/ji0IDbBbTd1BYMslCIBtukajcgABI76B6OECDwLCeASNQKlbNvML0R4BhdDiGCAoBAZw4IIcCR+BDeHABdkNLgL8kXLsws9A8JHQCJQ6bheFpyhkN+jsZQin+4VPEJ5dkCMpZy9DeNk9Nd3QEPCZDuCCtKoGi6EtkuAANsQAAPa6MAAA/18RGKAsvLMaBCBWrJD1Bka7EIKO09s3AAAAAElFTkSuQmCC";
        String options = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAAAzElEQVR42u2WsQ2DQAxF8R63EgPQIiUVM2SBSERighR0dCwIMpG5szig8r8i/tJvaP4T9tmuKpfLBREt2gUA5um7efx0m/lbCGGBAnBw92h2wyFSACkHEEBD5MMhPXIF8StV/3pag0SIY5iGMCyRhhj6994XAtA2tSWEfhkcJiBsATB8LRFAgs4MBThOTcIDcFjOUADoeAYC6LrKYoICpBuxKED6J8A9QOoeiB1OyCakk6PkXyFk6YiLzITc/C9yMQF2wL2Md4DL5brUCs+rdezFsmgEAAAAAElFTkSuQmCC";
        String prayer = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAAA7klEQVR42u3XwQ6CMAwGYPYevLpHE716wKNHowfDS/gcM8PUdbUrGZPWkDXphQT28cMY67pW2yrnzQGP5+iNIRHR9703AeyG/YQ43QarNL4RBmk0RARghMF7kUcopREBFKGURgrgECtCnOcAGHG4HqdOIdUY56XBMeJ8uX8gfCqLQPLAGAANEKkLIC65+K+7CDJ3V/Ti4RhOKZdEmMIF0zg+yzkEHAMA/4IWA94VT5Ix3N3TgRcBOBAHAQRM0dB08FW+GRRR+dzrIdzaobZ+SAjVlRQjlFOQEep/Vg2R23f8BcJ0F2aYAv2kt9pIvQCCS+37ZF2z9AAAAABJRU5ErkJggg==";
        String quests = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABXElEQVR42u2XMW7CQBBFuQE5gMvcg0OkTAk3oKJLxwloo5RIVIC4QMogkRyCBhEJgSLSedG39K2vkScgeTcF2pG+Fq/t/W9nPJbpdHLkyHFv8dDtBk//Zj54+nKVFEbNzz/vrhQmCYA1/N0tQ++5dGGigSjAaftZi2YeRDQQD4B6nR5Cf1SG8eSYDgQ3vwwPNcTH/LsyhDkFCIyYhx57p+qYELgf6xRFEVo/B9w9Fm2CgACA48XsLU42NAsKoruGWA4CcH46W7XPhkKgCzA2ZQAjAFimZBDoAAiGVsfzvj5PAYqKBrFeb+pdY07LQVMLiXN8NqJAqGzadfcKF70cFgJiRjQDBAGAdkjrNrUg2hGE0E4BiAcQBYKdgZ3qy0lLwHJFycK1ssAQAgR/25dU6yzcAgLZ9CcBsCAejJonAbBfVjRqEq9JAsDAwn99Y9I8GYCF8ZT/CuTIcVdxAQGrCVTiQ0XJAAAAAElFTkSuQmCC";
        String side_border_bottom = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAHklEQVR42mMI9XH8j4wZMASKUgL/I2MGPW3l/8gYAPy5HY1UknzFAAAAAElFTkSuQmCC";
        String side_border_bottom_selected = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAHklEQVR42mPwsDP+j4wZMASKUgL/I2MGPW3l/8gYALrFHEXcC2cZAAAAAElFTkSuQmCC";
        String side_border_edge_bottom_left = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAJUlEQVR42mPQ01b+X5QS+D/UxxGMGWACMEEGEEAWZIABkCAIAwB+mxfJM6DqXAAAAABJRU5ErkJggg==";
        String side_border_edge_bottom_left_selected = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAJUlEQVR42mPQ01b+X5QS+N/DzhiMGWACMEEGEEAWZIABkCAIAwBmwRdO85Uc8QAAAABJRU5ErkJggg==";
        String side_border_edge_bottom_right = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAJElEQVR42mMI9XH8D8JFKYH/9bSV/zPAOHABFA4IgBhwDhAAALs7F8ljynRqAAAAAElFTkSuQmCC";
        String side_border_edge_bottom_right_selected = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAI0lEQVR42mPwsDP+j4wZMASKUgJRBfS0lf+7u7v+5+XlBtMAnfcbUgRwLZ4AAAAASUVORK5CYII=";
        String side_border_edge_top_left = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAIUlEQVR42mNggAI9beX/IAznFKUEgjEKJ9THESEA4oAwAHzkF8nfUUFkAAAAAElFTkSuQmCC";
        String side_border_edge_top_left_selected = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAIUlEQVR42mNggAI9beX/IAznFKUEgjEKx8POGCEA4oAwAHgZF06+zeRuAAAAAElFTkSuQmCC";
        String side_border_edge_top_right = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAJElEQVR42mPQ01b+D8IMMFCUEvgfhOGCoT6O/1EEQQIwQZAAALmEF8mBw5O9AAAAAElFTkSuQmCC";
        String side_border_edge_top_right_selected = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAJElEQVR42mPQ01b+D8IMMFCUEvgfhOGCoT6O/1EEQQIwQZAAALmEF8mBw5O9AAAAAElFTkSuQmCC";
        String side_border_left = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAGUlEQVR42mPQ01b+X5QS+D/UxxGMGUgXAADV1x2Na3cviQAAAABJRU5ErkJggg==";
        String side_border_left_selected = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAGUlEQVR42mPQ01b+X5QS+N/DzhiMGUgXAACuyxxFbu/tngAAAABJRU5ErkJggg==";
        String side_border_middle = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAEklEQVR42mMI9XH8j4wZSBcAAO75HhG3ew1wAAAAAElFTkSuQmCC";
        String side_border_right = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAGklEQVR42mMI9XH8D8JFKYH/9bSV/zOQLgAA5Kcdjav+D1wAAAAASUVORK5CYII=";
        String side_border_right_selected = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAEklEQVR42mPwsDP+j4wZSBcAAJahG4GFhVh5AAAAAElFTkSuQmCC";
        String side_border_top = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAHklEQVR42mPQ01b+j4wZilIC/yNjhlAfx//IGEMAAL3FHY2B4wGaAAAAAElFTkSuQmCC";
        String side_border_top_selected = "iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAYAAACp8Z5+AAAAHklEQVR42mPQ01b+j4wZilIC/yNjBg874//IGEMAAKdhHEVsaSlqAAAAAElFTkSuQmCC";
        String small_left_right = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAMklEQVR42mNgQAKxER7/KcUYhmmoylGEqWoY2EBqGgY3kFqGjRo4auCogaMGDnUDqYkBgz9rMZzKSykAAAAASUVORK5CYII=";
        String small_left_right_hovered = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAMklEQVR42mNgQAKxER7/KcUYhvl42FCEqWoY2EBqGgY3kFqGjRo4auCogaMGDnUDqYkBl2T3QLxD9zUAAAAASUVORK5CYII=";
        String small_left_right_selected = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAMUlEQVR42mNgQAKxER7/KcUYhtmZalKEqWoY2EBqGgY3kFqGjRo4auCogaMGjhqIwACyF6fxtzhvOAAAAABJRU5ErkJggg==";
        String small_middle = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAJ0lEQVR42mOIjfD4T03MoKEq95+aeNTAUQNHDRw1cNTAIWMgtesUAGemaNf5PMpWAAAAAElFTkSuQmCC";
        String small_middle_hovered = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAJ0lEQVR42mOIjfD4T03M4ONh85+aeNTAUQNHDRw1cNTAIWMgtesUAO1A/sMK8ozVAAAAAElFTkSuQmCC";
        String small_middle_selected = "iVBORw0KGgoAAAANSUhEUgAAABQAAAAVCAYAAABG1c6oAAAAJElEQVR42mOIjfD4T03MYGeq+Z+aeNTAUQNHDRw1cNTAEWsgABhZqf93OuBRAAAAAElFTkSuQmCC";
        String stats = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAABNElEQVR42mNgGAWjYBQMLcD4n1iVvHx8/9Ex1RwhIyPznxgHNPS0o+BNJ7dRyyGM/wX4+f8TckD6vgQUB6w4vvK/U6sb2BHEeIKokMBlEMiSuduWYmCQA6juCHyhELEwBgWPOgKG58ydQn1HIKdwbNkQlyP0ik2pnzBBBu7z9ETBIDGYr2EY5AiQA6juCGwOIOQImRhl6joCmwOmqWlhdQSonAA5YPg5AoTxOQIW/zCMzREU1iuQkFhuboyCSXEEWI39bBTsFrSMFIeQ7ojimjwUR2BzgIZCEClRBXEEyEJkTIwjQHIgC9ExyAFUdwTM1zAMcgSPqRBYTsvcCwWPLEeAsinMEdqqVigYlCaGriNAGJcjwI4k0RHqXLb/CTWWsDqCFpikkhTmYlrg0d7MKBgFpAAAQJ/TfCW/zwkAAAAASUVORK5CYII=";
        String stone_bottom_left_selected = "iVBORw0KGgoAAAANSUhEUgAAACYAAAAkCAYAAADl9UilAAACXUlEQVR42rXYPU8DMQwG4N4AFFSqFmjVCooQIBYkJhYkFiQ2NoYODExsTPz/4ZB7fXWOz3acfpxkqXC55KntpNBeL7mqGjE5OthL8DXSMK9mwNf1rP6+mdU/t/P69/7SDLqfC5oHQfN+Xk1X8TG/SOJ9dmYBq9VNengXIKBoPoSGojUpXiej+uV8WD+PhxJXdVB/D4tVRHHIMiKKepuOfZjMVAlKZolna+nAgOKwx+GgwVFD8mwhU1EY7yMOAkaikCkP1mySdRllCS2c1dgyNJRWwhBMojhMZkrDlMA4CCg3Y7nyaVlarkP2lIXSdmMxLNdLS6WftLMqCrsbnNiw3IGZK5cVWm9RmDCaGItbpYvuOg/lNT3F0+i0C5MHpHUueYdmDsWbXsuWCsOCMjNelkpLqJVR7sgERg9zXG77l5bPK6MLo4ewmARZuy4Hkyir8V0YPYAJLQTHlGaL5rc+hiRscdwHrP2zx8NFesnLlgaTBytlqwPDuyoBbFtKrYwdGAZHcVgMr6Mnfa7xOzC6SQ9gW8uF5esczMsWUGEYDeTvigNzUXracxihAJv3DzmsxUkgn1xm08qeNmYrGN3UcDIiSNzDeA2lwUQpWxjHAaghOQ4IAOTHD/+Hw+ovJ2M6zoJpJ7j1Ow71Gj8EA45PIJHytXdf+6NQohyYjisNALTsSJSEKT3m4/jPFpgjPJAHczLW4jBYorxNUpJZiQrCYjgtq5uiqIxBWIrzIgfXgoOAKoC1X1FhggjUwlpj02xVUVgKjMIigTeKbG2A6gIx2S4i/cZx66vaw1egzfUPoJfEQAULzHAAAAAASUVORK5CYII=";
        String stone_bottom_right_selected = "iVBORw0KGgoAAAANSUhEUgAAACYAAAAkCAYAAADl9UilAAACqklEQVR42s3YvW8TQRAFcKcATJSYBPJlgaMIEAqKFFHQINFESkdHYSEKKjoqCij45w/Gp5e8ezsze2u7wNLIH/Hd/vJmd8+6yaR47HRax48epHU67Ws+fRhW7RyT+NEjPs2Puh+vn3ffX85Xzyh7j8/0NX/G9e3irPt63tfnFyd3ZWPgGXUfhKAAioox2d8VCpxBlv+elw7S6vbsaff+cKa4nWLQn28WxesMlmE5MU6QUTcnh93H4wOG9Wl5MJQC9fMajFPTpAAz1ABmE8++yDAb9Nfl+ao8YGtiCgOGCzBr52oxMMwG//P2YlWKWhfmoRiGFlp9eDa7n2cGQysNA9TYtLzVmCWlMEVdzfaGMBvk92WfliblwTyElW4T3kTXCW8oF2YHchsxx3R1eiggFKP7l5eW18YCFq3EWkoeprYCgWKYoaxe7e0OYViVvCXo3sUoRnxZnA4g0QaqpbDrg/0hzA60/37sxM7S8VKqwbiNBcwGiK6PLShAaolxK1MY2hld77z5pC3UlLLU0EK00VAFzOQKY1RLUpxYhvNWYwrTi28tpU1gQKUwnmfRJolajkhMMR4MqGJ+4SKOA/GzJEPVasz8suK03j3Zv0usgPHJrV3bAkUr0mtjAUMreZlnm2YLKlqR2kYXZl/kdm4jlaiwdynInWMWawRrSSLD6OWHMajB732FjYFklxgA8Nr7BWHXREWFMLQzA2Jwhngg3tWz/aoKwwkwgOKiXwReaUJroTQxnIzbEIEwKL+PUqqhQphtcHwSKy8NYDgJftaEeD41oQDjJcsn5cG8lLxkvN28GQUYvuThGKhpeqBof2pCKczDee+5TdyqsaAqCrDF42lxYDTYOohmFO5dRLhtV3CrKcf9Z6BhakhuG2V3ETcAlXcUa7ckx9amoL+5++Yhp3AHAgAAAABJRU5ErkJggg==";
        String stone_middle_selected = "iVBORw0KGgoAAAANSUhEUgAAACYAAAAkCAYAAADl9UilAAACnUlEQVR42sWYzU8UQRTE4aAigRXkw93oEqLGQEwMBy4kXky8eeOwIR48efPkQQ/+86M1m4Ki9nX3m92sbFKZBaa7f1S9fvOxsbHw2ezWr0Gf+aAvk8Pux9uX3ffXk/5I4Wf+Tr/736Fvp+PuZvqiu351fE+Y+/P4+RDAO6CSHMyPgKG+noxvQSgAfTre7z4e7XWX+6Pu/WgnA7e54MDPd9OF7+4YBRDClaAgQA0Am7sVgakcVgEBQ2lsFJyCrg5GPRTB3uxsl+EmW4/7iRQMAL/OTno5XAQW1ZI6pW4RjmBHTx61wbD4n/PTXg5Vg0OEmMMd07pSt6gmGKMEDKFaYFp3GmfkmIN92NvNg2GR32dztxREIUu7lUU/+6eo6AmnbqWj1BgJpMcSFJ2aiVsapQqxDgbzndjqZ94eog3A+sIx6mPp4tfaqRU6YLyZRjtSwZbalZgIi0TNtdazIrcczKG01lJg7N61+ByqBBb1L3csDeZNVoEYmcLgiAu170QFc8cGg2EwwaLroIJluryCEUgbLeGmT7fyYLXoeCujLSELpo4NAtM6iyIstYRSjA5GIN2VTTBMQhc8OoeaBXcQHF8r/KXBdPES0Cy41ypFWYIaBMYo6RpqKbo1zkKVIvT7sSYYJtA4S4qgohbRcotgWLsKhgElsBYMr4PZ2loarCWe59ERKBNjOkpew7hQ1iGC1BppCSrlmE7KhTO9ySNz0Ajs4tnu7Z3FIDCfvFXUDhZdEyO3UmAc5ItEi7kLClCCcSiCNWuMJ9cmVxAFr4Go8ACiUCnHcJLC6X9Yg9TzWDvqTPTwoUqBUTqpWr+qHAoxVsHwiI6TIrjaxKuIUFDz/YXDrVMES73t+V9ArK0k2N2LOw5ap1Z6s/jQrzr/AgdMRO1F0sD8AAAAAElFTkSuQmCC";
        String stone_top_left_selected = "iVBORw0KGgoAAAANSUhEUgAAACYAAAAkCAYAAADl9UilAAACjUlEQVR42rWYMW8TQRSEswUQomAlQIItMEKAaJBS0SDRRKKjo7AQBRUdFf+/OPSM5jQ3nre7l3MsTaKzfbtfZuZ2L3dysuhVhuPpKK//g/15/7Kq3283o369WQ8/ti+G76+uJ/q2eT58XT9dCuiB/n7YVqFCP1+vRxAogG6vL4cvVxfDp8vV8HF1PhfuEEhh9LgHKhRQdwQr40QOJH6zHBzHBoVToc/PVnsogL07P+uBK5NJan1SMHXLORZOBRjgAHb16MFQhYpBWwWvgUXhYwyFAxScYjXAStOhnisSYOoYuwWgm4snLbB+qOx7zi0tfUj7VYmyDqVLgEqhdgTFMUJc/ibY3EVT4TQ+XUyxbuGq5KUiASuz+gMIjoyPFUgXVAiORccWgak7DKZXYAbGcHxFHgVMgWIfrIFxt5xjCVi5c3wACgAcR+l5MWUwdYxdC7Dt41MP1rry5kanyjqWgvUAYYvRCHVJWAK2OX3oweAIInPKnFIwB8hgbp88cEydUGmEDLNLth0HlrmF5WIEix9cXAcV73PJGWhn7rWyKBXKXZHkWBn7weItBT1yt8a9UC5Ct1dOwGC7TrhLetSCckuEc8vtk1T+sj9RB3UALRBe3XtibILFl7OJetyB4xodgLIY3T45ibIG1nJKHdI7BwZzUFXH4ksYuBVVVnCOit1x7zEUX5EHYPEh/9Vu8jnlzsAUSKEsGCx324iTu79yMTkYjY816RgG0E70wPZExQVvgU0c4xO0oDwp3xZnkWXOsFyEFizewEn4N0qFybNoaiDsjh5rjAd3F/iwNnDP5JkTLQEqRI8ISvcAbvIlQAomzy3KokGXAqFbBqwOFyez1fehxoO7si/efar3Uec/MDrMSZau4z0AAAAASUVORK5CYII=";
        String stone_top_right_selected = "iVBORw0KGgoAAAANSUhEUgAAACYAAAAkCAYAAADl9UilAAACqUlEQVR42rWYQYsTURCENwd1lTXuqrsmaGJQkYggHrwIXgRv3jwE2YMnb548KOifj9QLNan0dPd7k8RAMZnNJO+b6nrdy5yc9F6j9fF0lNfmxz5PH65/vHi8/v5sWo6R8Dl1PZ8UfXlyVb4Pfby6OAbgFqhVCvZtMXHhPk3uFx0AOOo59PPlrDvyvQdFx77OHhUoD2xPwI1bHpgHpWBwyrqlcIBBSakPl+dFTXCXt26UH1IwwPxazjtZQFtGwq0EzjpGsPcPxm1wCobF/75aFP1ZPu0Aa84pZFRO69q7i3EOBzCWEhCAwrEFLCrv9dwHVDA4B4VwBMOP0y0t4e/lons/pHWsgh2qzqVwLKWWEQKQZq3mkm4C2zZUBFTn3LISzO7EyKEo+N7OzNpHMxjDX2sTBIl2YwRly2nBenDMGBaJGqo6pe5kDrWCEaoKlpXPQnluebnypoB17PX4zAfDSLHd35uFdCkDi5zKwHpwAIO1zJk3B6OxU8uUB2YbbTNYVjod1EPCbl1SMM1ZCIbFoxLWgDy3WsDUsZ0NADB8idkAjHVLF18548bCtATeg3LBuBjKFQHpmGnJk/ffRQ2sKydLqb0HcFGeoh6VwdlM6ZxMwXAhXVtV8pS5VWsNFqoKhgs0Zy0Nc6hb1jUP7O29uzHYPopy5ZVR86Vgb843UD0wljMDzAA8oChfkWOAen52ZzdjtJs/WOvcLWC2y2dgdCsE41Hv2hslGZwHVAu8C8YLvDvLVHOlpTVY7YDxj7hY70zDqgtkADr7sp1nYVQdGE4UTqUwPPfK4zmSuWNhQjDKgxsqr0QtQNDs9inn5aicWLhDVFu8AWr7/MLCtUB6nw8FseqB7XuXh7gDTU9vZmDbB3e48BBxMT23smBU5UFL/5ElNsj/loX6B1aW0SoLKLCzAAAAAElFTkSuQmCC";
        String side_panel_background = "iVBORw0KGgoAAAANSUhEUgAAAFgAAAA8CAYAAADi8H14AAABNUlEQVR42u3cywrCMBCF4XkaQdCNoAiC+P4vpbRYFC9oNXPNvzgbQdJ+1HQyJMphszgPOW6XKjntVs/Zr2+5fqY1vmcGV9EG/ojsBGwx7ghseTPv4oWrPX4IYI+fbnlg77nR8lqk0pw393osxpGKb+9IARhggAnAfi9kgJWrDMle05YCjrYiy7AYkcw9BZOV511TymwO7u0J/uceAY4I/Gs5o913jjgXm5VpU2PfosEfAXj6jskT/IibCdoV+Jt6sQpuyCkiMy7AvQNnx23V+DEHpl2pCE0/mDTvqgGs3FEDmCkCYAIwwAATgAEGmAAMMAEYYIAJwAADTAAGGGAQAHb7r4cWWw1MgaNs2J67YTHVYfAIyN0ARz16kA4428mkltu9AAY4bwUBcJU6GGCAAQYY4Je5AFpBISJu7T2/AAAAAElFTkSuQmCC";
        String side_panel_edge_left = "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";
        String side_panel_edge_right = "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";
        String tabs_bottom_row = "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";
        String tab_stone_middle = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAAD7UlEQVR42r2Y70sUURSG9V/oQ1GmZIJkiSRpuIWSxUpq1oZlKuYvWrIwM/NDikRGfqgPEf3Dk+/dntkz597R7YMJL7PO3Lnnue8598zstrVFf+3Z2av0rzFgrlbNDj4sR9p7txT0eWctP3e4ux6OOrf7djEfs11/nm2uzWbrizMFLTydyGpTY2UwzeCaUJN7EYDAFkDnBaHgOxsvcgAFXXo2GTT76H4AmKrezcZHh7ORoQEP0p4HQN/36+F49KkehBuHH1fC0bqj4IKwAAoMhAAkAVTHK9lo5ZaHaLjgIX4cvMkliJQ7CowDCg7A6txUAJA0twWQC4IYGuzP+vt6GyCdHefDjVoZq7YAklzR0UPoHkFsLNeCyD0u4ICFeDA2EkAE0dfbk128cK4JISeO9jey39+2g35+2QzBkXeFFOFECkTBHz9s1AHB5QLHAoSoBaEgAvAOpFLDcW9rNYDYdNhibLpwOwe4M3wzDaEq1+pPgiBdQISdcQyx83ohANRf1nKAVDpwgMKM0oELv76+D59JR6o4FZzeQFEKQFqZny6kowxENdHb012EiHbEcX2Elet4LNsv2BWkQbUABLtDu2JmcjwE1lEQOrJFBXG1u7MJoZtCYf7dGQrK6mleNCVZr9XTG7ZeLeTBfT0A4UVdFJxQ/tRoyDXbEdu9/bYvWAdSENL0xL28OG1KIghNTDsm/wRnKxLYygLQqqkBAKwjNKzICd2gvCqQXTlt2QNorIVQMaZ2hHoEbpyaDg3WKngSAkPO2YL0AW+/D24hfD0oJfSMAoQuAoH1dvXUAB3RbsOTIFKFCYScKOwOXdRk1IV9NFvbfQ3oHh5Qp0E0gldyF6Itque8VqOJ2Xq+BkhD2U5IAbArrAMWopAOQdgKTwW3LhAcpdzwqcCFUidUQEyoQDwRbScsA0jVg3cBJ7QrbNuOakI3A4EjZfan3ppOLsZKDsEDbHDgehFCF4HwL6c2qFWrBWmLEgjtjAhCA4Dwq20lMA8oBaRBpQrSQkTp0FsPKZHmn1Rzq7Gd3KuIbSPyDcn+b4vRv0tETnATqymzuawLWskFxlgAhAt6yU06YQMooCrcfl8orjAt/6CyDuCCIAZuXCtCiE6DmQAoOynnCUYAXmC5pqPE+6SvA0mpiJzgogbbAFYEkwCx5/yqWZiHAEDvl12XLzUhZI0uAkLuZB2T2gAAMHmZ7FweQC37SldHE0IndREYBZesheQyJd2D7Dl7HwCSAJSK3Al9DdNJCRgmsJML0ApoPiP/vz2HAwBIhe+jHuQsRAxAom/ldoBAWlUr4+3c1IKU/I1CwiYGSpz71/Nln1v+xeZ//lz0B/tiHaRFlF+CAAAAAElFTkSuQmCC";
        String tab_stone_middle_selected = "iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAYAAAAHKVPcAAACmElEQVR42r2YMU8bQRSEoQiQCBxIAthKjFASRURIiIImUhokOjoKK0qRii5ViqTIn79kzhozN/ve3krIII3O2Hs73817u3f2xkbxt9mtX+nfcsDt7E338+Pb7v79rD9S+J/v6Wv/HPpxOu2+zY+7u3dHA2Hum+mrDObBPJND+BHG1PeT6cqUgvn10UH39XC/uzqYdOeTXQfZLK7s16d58dqToGBKkAwAAkACsUwhglA5mMLAmNLoKSQAfXk96QEI8WH3xRJktrPVn6QQMPt9dtLLQSKIqPaagKZAEEIcbj8bQsDo7+fTXg5QA0EZMIcnoX2gKVADCJYDxgQYg9A+0ZJESTjExf5eDIEJ/5wtU1BTBcpWDRty8V9RQxJEUwjLoaWguR4zACawkBS0HCqUpgrhK2Jsv/AlGTUn+wHHaJ8IG1NrXWtCGPvGFK0MhRhdHTgJE0YbVW1PiFJwCAfQ3igguOvVSuAAGUS0P3gSIYRvWGrO2NUYR9ykfEUohCdRhcBAQkT3BYVo2R0Vgua6aRFk/nwnhqjFz9uzLsNWCE0ihdC+iMqQLcOsFA5Bc10dAwicwKvz+B1gEdwpeX6tKZsg1CgzXwTPClk5MoAUguVgGqh99HjWCpCVwZ8nBhAYrCXJFAFEy3IsBULAewWBDzOIMWPeF1p7oQliTBzn8dO8pRRhObinc9LWK6dpbVPKAIokdAKatKx9j92hIojLl3urO2gK4RONNZxDRPeIKIUCggN8wmhivzo1y4wdgBCDnuAHtYnUVCFrpio83CpAkQTeUBAlrwHpONZarzh6sFUVEJROoPE9Vg6AUqwg8DUMb0QgtUkeIwJAg++jDrJOEaL4Vv5U5uyFAOLhRxIOWKeaf7F5yp+L/gEwRETtdArDhwAAAABJRU5ErkJggg==";
        String tabs_top_row = "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";

        TabParts.combat = new ImageRGB(Base64.getDecoder().decode(combat), MouseHandler.gameCanvas);
        TabParts.emotes = new ImageRGB(Base64.getDecoder().decode(emotes), MouseHandler.gameCanvas);
        TabParts.equipment = new ImageRGB(Base64.getDecoder().decode(equipment), MouseHandler.gameCanvas);
        TabParts.friends = new ImageRGB(Base64.getDecoder().decode(friends), MouseHandler.gameCanvas);
        TabParts.ignores = new ImageRGB(Base64.getDecoder().decode(ignores), MouseHandler.gameCanvas);
        TabParts.inventory = new ImageRGB(Base64.getDecoder().decode(inventory), MouseHandler.gameCanvas);
        TabParts.large_left_right = new ImageRGB(Base64.getDecoder().decode(large_left_right), MouseHandler.gameCanvas);
        TabParts.large_left_right_hovered = new ImageRGB(
                Base64.getDecoder().decode(large_left_right_hovered), MouseHandler.gameCanvas);
        TabParts.large_left_right_selected = new ImageRGB(
                Base64.getDecoder().decode(large_left_right_selected), MouseHandler.gameCanvas);
        TabParts.large_middle = new ImageRGB(Base64.getDecoder().decode(large_middle), MouseHandler.gameCanvas);
        TabParts.large_middle_hovered = new ImageRGB(
                Base64.getDecoder().decode(large_middle_hovered), MouseHandler.gameCanvas);
        TabParts.large_middle_selected = new ImageRGB(
                Base64.getDecoder().decode(large_middle_selected), MouseHandler.gameCanvas);
        TabParts.logout = new ImageRGB(Base64.getDecoder().decode(logout), MouseHandler.gameCanvas);
        TabParts.logout_small = new ImageRGB(Base64.getDecoder().decode(logout_small), MouseHandler.gameCanvas);
        TabParts.magic = new ImageRGB(Base64.getDecoder().decode(magic), MouseHandler.gameCanvas);
        TabParts.medium_left_right = new ImageRGB(
                Base64.getDecoder().decode(medium_left_right), MouseHandler.gameCanvas);
        TabParts.medium_left_right_hovered = new ImageRGB(
                Base64.getDecoder().decode(medium_left_right_hovered), MouseHandler.gameCanvas);
        TabParts.medium_left_right_selected = new ImageRGB(
                Base64.getDecoder().decode(medium_left_right_selected), MouseHandler.gameCanvas);
        TabParts.medium_middle = new ImageRGB(Base64.getDecoder().decode(medium_middle), MouseHandler.gameCanvas);
        TabParts.medium_middle_hovered = new ImageRGB(
                Base64.getDecoder().decode(medium_middle_hovered), MouseHandler.gameCanvas);
        TabParts.medium_middle_selected = new ImageRGB(
                Base64.getDecoder().decode(medium_middle_selected), MouseHandler.gameCanvas);
        TabParts.music = new ImageRGB(Base64.getDecoder().decode(music), MouseHandler.gameCanvas);
        TabParts.options = new ImageRGB(Base64.getDecoder().decode(options), MouseHandler.gameCanvas);
        TabParts.prayer = new ImageRGB(Base64.getDecoder().decode(prayer), MouseHandler.gameCanvas);
        TabParts.quests = new ImageRGB(Base64.getDecoder().decode(quests), MouseHandler.gameCanvas);
        TabParts.side_border_bottom = new ImageRGB(
                Base64.getDecoder().decode(side_border_bottom), MouseHandler.gameCanvas);
        TabParts.side_border_bottom_selected = new ImageRGB(
                Base64.getDecoder().decode(side_border_bottom_selected), MouseHandler.gameCanvas);
        TabParts.side_border_edge_bottom_left = new ImageRGB(
                Base64.getDecoder().decode(side_border_edge_bottom_left), MouseHandler.gameCanvas);
        TabParts.side_border_edge_bottom_left_selected = new ImageRGB(
                Base64.getDecoder().decode(side_border_edge_bottom_left_selected), MouseHandler.gameCanvas);
        TabParts.side_border_edge_bottom_right = new ImageRGB(
                Base64.getDecoder().decode(side_border_edge_bottom_right), MouseHandler.gameCanvas);
        TabParts.side_border_edge_bottom_right_selected = new ImageRGB(
                Base64.getDecoder().decode(side_border_edge_bottom_right_selected), MouseHandler.gameCanvas);
        TabParts.side_border_edge_top_left = new ImageRGB(
                Base64.getDecoder().decode(side_border_edge_top_left), MouseHandler.gameCanvas);
        TabParts.side_border_edge_top_left_selected = new ImageRGB(
                Base64.getDecoder().decode(side_border_edge_top_left_selected), MouseHandler.gameCanvas);
        TabParts.side_border_edge_top_right = new ImageRGB(
                Base64.getDecoder().decode(side_border_edge_top_right), MouseHandler.gameCanvas);
        TabParts.side_border_edge_top_right_selected = new ImageRGB(
                Base64.getDecoder().decode(side_border_edge_top_right_selected), MouseHandler.gameCanvas);
        TabParts.side_border_left = new ImageRGB(Base64.getDecoder().decode(side_border_left), MouseHandler.gameCanvas);
        TabParts.side_border_left_selected = new ImageRGB(
                Base64.getDecoder().decode(side_border_left_selected), MouseHandler.gameCanvas);
        TabParts.side_border_middle = new ImageRGB(
                Base64.getDecoder().decode(side_border_middle), MouseHandler.gameCanvas);
        TabParts.side_border_right = new ImageRGB(
                Base64.getDecoder().decode(side_border_right), MouseHandler.gameCanvas);
        TabParts.side_border_right_selected = new ImageRGB(
                Base64.getDecoder().decode(side_border_right_selected), MouseHandler.gameCanvas);
        TabParts.side_border_top = new ImageRGB(Base64.getDecoder().decode(side_border_top), MouseHandler.gameCanvas);
        TabParts.side_border_top_selected = new ImageRGB(
                Base64.getDecoder().decode(side_border_top_selected), MouseHandler.gameCanvas);
        TabParts.small_left_right = new ImageRGB(Base64.getDecoder().decode(small_left_right), MouseHandler.gameCanvas);
        TabParts.small_left_right_hovered = new ImageRGB(
                Base64.getDecoder().decode(small_left_right_hovered), MouseHandler.gameCanvas);
        TabParts.small_left_right_selected = new ImageRGB(
                Base64.getDecoder().decode(small_left_right_selected), MouseHandler.gameCanvas);
        TabParts.small_middle = new ImageRGB(Base64.getDecoder().decode(small_middle), MouseHandler.gameCanvas);
        TabParts.small_middle_hovered = new ImageRGB(
                Base64.getDecoder().decode(small_middle_hovered), MouseHandler.gameCanvas);
        TabParts.small_middle_selected = new ImageRGB(
                Base64.getDecoder().decode(small_middle_selected), MouseHandler.gameCanvas);
        TabParts.stats = new ImageRGB(Base64.getDecoder().decode(stats), MouseHandler.gameCanvas);
        TabParts.stone_bottom_left_selected = new ImageRGB(
                Base64.getDecoder().decode(stone_bottom_left_selected), MouseHandler.gameCanvas);
        TabParts.stone_bottom_right_selected = new ImageRGB(
                Base64.getDecoder().decode(stone_bottom_right_selected), MouseHandler.gameCanvas);
        TabParts.stone_middle_selected = new ImageRGB(
                Base64.getDecoder().decode(stone_middle_selected), MouseHandler.gameCanvas);
        TabParts.stone_top_left_selected = new ImageRGB(
                Base64.getDecoder().decode(stone_top_left_selected), MouseHandler.gameCanvas);
        TabParts.stone_top_right_selected = new ImageRGB(
                Base64.getDecoder().decode(stone_top_right_selected), MouseHandler.gameCanvas);
        TabParts.side_panel_background = new ImageRGB(
                Base64.getDecoder().decode(side_panel_background), MouseHandler.gameCanvas);
        TabParts.side_panel_edge_left = new ImageRGB(
                Base64.getDecoder().decode(side_panel_edge_left), MouseHandler.gameCanvas);
        TabParts.side_panel_edge_right = new ImageRGB(
                Base64.getDecoder().decode(side_panel_edge_right), MouseHandler.gameCanvas);
        TabParts.tabs_bottom_row = new ImageRGB(Base64.getDecoder().decode(tabs_bottom_row), MouseHandler.gameCanvas);
        TabParts.tab_stone_middle = new ImageRGB(Base64.getDecoder().decode(tab_stone_middle), MouseHandler.gameCanvas);
        TabParts.tab_stone_middle_selected = new ImageRGB(
                Base64.getDecoder().decode(tab_stone_middle_selected), MouseHandler.gameCanvas);
        TabParts.tabs_top_row = new ImageRGB(Base64.getDecoder().decode(tabs_top_row), MouseHandler.gameCanvas);
        TabParts.setup = true;


    }

}

