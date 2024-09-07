package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.sound.MusicSystem;
import org.runejs.Configuration;
import org.runejs.client.util.BitUtils;
import org.runejs.whitelabel.Images;

import java.awt.*;

import static org.runejs.client.MovedStatics.*;
import static org.runejs.client.cache.media.TypeFace.fontBold;

/**
 * The class that handles the login screen.
 */
public class LoginScreen {

    // Define the LoginScreenState enum
    public enum LoginScreenState {
        INITIAL,
        LOGIN_INPUT,
        CREATE_ACCOUNT
    }

    private static LoginScreenState loginScreenState = LoginScreenState.INITIAL;

    public static int loginScreenFocus = 0;
    public static ProducingGraphicsBuffer muteButton;
    /**
     * Part of login screen
     */
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1631;
    /**
     * Part of login screen
     */
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1206;
    public static ProducingGraphicsBuffer flameRightBackground;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_1285;
    /**
     * Something to do with flames, maybe
     */
    public static int anInt2452 = 0;
    /**
     * Something to do with flames, maybe
     */
    public static int anInt2613 = 0;
    /**
     * Something to do with flames, maybe
     */
    public static int[] anIntArray1013;
    /**
     * Something to do with flames, maybe
     */
    public static int[] anIntArray1198;
    public static int[] anIntArray2865;
    public static int[] anIntArray3248;
    public static ProducingGraphicsBuffer flameLeftBackground;
    /**
     * Something to do with flames, maybe
     */
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_918;
    /**
     * Something to do with flames, maybe
     */
    public static int[] anIntArray466 = new int[256];
    /**
     * Something to do with flames, maybe
     */
    public static int[] anIntArray178;
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_2043;
    public static ProducingGraphicsBuffer loginBoxGraphics;
    public static IndexedImage loginScreenBox;
    public static IndexedImage imgLoginScreenButton;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_907;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_463;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_2524;
    public static int[] anIntArray3255;
    public static int[] anIntArray1168;
    public static int anInt1641 = 0;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array535;
    public static int[] anIntArray1445;

    private static final boolean SHOW_CREATE_ACCOUNT = false;

    private static int offsetX = 0;
    private static int offsetY = 0;


    /**
     * Sets the login screen state.
     *
     * @param state The new login screen state
     */
    public static void setLoginScreenState(LoginScreenState state) {
        loginScreenState = state;
        switch (state) {
            case INITIAL:
                break;
            case LOGIN_INPUT:
                break;
            case CREATE_ACCOUNT:
                break;
        }
    }

    /**
     * Recalculates the offsets for centering the login screen in resizable mode.
     */
    public static void recalculateOffsets() {
        if (ScreenController.frameMode == ScreenMode.RESIZABLE) {
            int drawWidth = ScreenController.drawWidth;
            int loginScreenWidth = 765; // Original login screen width
            offsetX = (drawWidth - loginScreenWidth) / 2;
            // Y offset remains 0 to keep the login screen at the top
        } else {
            offsetX = 0;
            offsetY = 0;
        }
    }

    /**
     * Updates the login screen state and handles user interactions.
     * This method is called every game tick when the login screen is active.
     */
    public static void updateLogin() {
        // Update login screen animations or effects
        method836(1);
        // Calculate offsets for centering in resizable mode
        recalculateOffsets();
        if (ScreenController.frameMode == ScreenMode.RESIZABLE) {
            int drawWidth = ScreenController.drawWidth;
            int loginScreenWidth = 765; // Original login screen width
            offsetX = (drawWidth - loginScreenWidth) / 2;
            // Y offset remains 0 to keep the login screen at the top
        }

        // Handle mute button click
        if (MouseHandler.clickType == 1 && MouseHandler.clickY >= ScreenController.drawHeight - 42 && MouseHandler.clickX >= ScreenController.drawWidth - 42) {
            toggleMusicMute();
        }

        // Main login screen logic
        if (Game.gameStatusCode == 10) {
            int mouseX = MouseHandler.clickX - offsetX - 202;
            int clickType = MouseHandler.clickType;
            int mouseY = MouseHandler.clickY - offsetY - 171;

            // Handle different login screen states
            switch (loginScreenState) {
                case INITIAL:
                    handleInitialLoginState(mouseX, mouseY, clickType);
                    break;
                case LOGIN_INPUT:
                    handleLoginInputState(mouseX, mouseY, clickType);
                    break;
                case CREATE_ACCOUNT:
                    handleCreateAccountState(mouseX, mouseY, clickType);
                    break;
            }
        }
    }


    /**
     * Handles the login input state where the user enters username and password.
     */
    private static void handleLoginInputState(int mouseX, int mouseY, int clickType) {
        int inputStartY = 60;
        int loginButtonX = 100;
        int loginButtonY = 150;

        // Handle username field focus
        if (clickType == 1 && mouseY >= inputStartY - 15 && mouseY < inputStartY) {
            loginScreenFocus = 0;
        }

        inputStartY += 15;

        // Handle password field focus
        if (clickType == 1 && mouseY >= inputStartY - 15 && mouseY < inputStartY) {
            loginScreenFocus = 1;
        }

        inputStartY += 15;

        // Handle login button click
        if (clickType == 1 && mouseX >= loginButtonX - 75 && mouseX <= loginButtonX + 75
                && mouseY >= loginButtonY - 20 && mouseY <= loginButtonY + 20) {
            attemptLogin();
        }

        // Handle cancel button click
        loginButtonX = 260;
        if (clickType == 1 && mouseX >= loginButtonX - 75 && mouseX <= loginButtonX + 75
                && mouseY >= loginButtonY - 20 && mouseY <= loginButtonY + 20) {
            // Return to initial login state
            setLoginScreenState(LoginScreenState.INITIAL);
            Native.username = Configuration.getUsername();
            Native.password = Configuration.getPassword();
        }

        // Handle keyboard input for username and password fields
        handleLoginKeyboardInput();
    }

    /**
     * Handles the initial login screen state, showing options to log in or create an account.
     *
     * @param mouseX    The x-coordinate of the mouse click
     * @param mouseY    The y-coordinate of the mouse click
     * @param clickType The type of mouse click (1 for left-click)
     */
    private static void handleInitialLoginState(int mouseX, int mouseY, int clickType) {
        int loginButtonY = 150;
        int loginButtonX = 180;

        // Check if the login button is clicked
        if (clickType == 1 && mouseX >= loginButtonX - 75 && mouseX <= loginButtonX + 75
                && mouseY >= loginButtonY - 20 && mouseY <= loginButtonY + 20) {
            // Transition to login input state
            setLoginScreenState(LoginScreenState.LOGIN_INPUT);

            loginScreenFocus = 0;
            Native.loginScreenMessageLineOne = "";
            Native.loginScreenMessageLineTwo = English.enterYourUsernameAndPassword;
            Native.loginScreenMessageLineThree = "";
        }

        // Create account logic
        if (SHOW_CREATE_ACCOUNT) {
            int createAccountButtonY = 200; // Position it below the login button
            int createAccountButtonX = 180;

            // Check if the create account button is clicked
            if (clickType == 1 && mouseX >= createAccountButtonX - 75 && mouseX <= createAccountButtonX + 75
                    && mouseY >= createAccountButtonY - 20 && mouseY <= createAccountButtonY + 20) {
                // Transition to create account state
                setLoginScreenState(LoginScreenState.CREATE_ACCOUNT);

                Native.loginScreenMessageLineOne = "";
                Native.loginScreenMessageLineTwo = English.createAFreeAccount;
                Native.loginScreenMessageLineThree = "";
            }

            // Draw the create account button
            imgLoginScreenButton.drawImage(createAccountButtonX - 73, createAccountButtonY - 20);
            fontBold.drawShadowedStringCenter(English.createAccount, createAccountButtonX, createAccountButtonY + 5, 16777215, true);
        }
    }


    /**
     * Handles the create account state, allowing users to input information for a new account.
     *
     * @param mouseX    The x-coordinate of the mouse click
     * @param mouseY    The y-coordinate of the mouse click
     * @param clickType The type of mouse click (1 for left-click)
     */
    private static void handleCreateAccountState(int mouseX, int mouseY, int clickType) {
        int buttonY = 250;
        int buttonX = 180;

        // Handle input fields (username, password, etc.) here
        // This is a simplified version; you may need more fields and logic

        // Example: Username input field
        if (clickType == 1 && mouseY >= 100 && mouseY < 120) {
            loginScreenFocus = 0; // Focus on username field
        }

        // Example: Password input field
        if (clickType == 1 && mouseY >= 140 && mouseY < 160) {
            loginScreenFocus = 1; // Focus on password field
        }

        // Handle "Create Account" button click
        if (clickType == 1 && mouseX >= buttonX - 75 && mouseX <= buttonX + 75
                && mouseY >= buttonY - 20 && mouseY <= buttonY + 20) {
            // Attempt to create the account
            attemptCreateAccount();
        }

        // Handle "Back" or "Cancel" button click
        int cancelButtonY = 290;
        if (clickType == 1 && mouseX >= buttonX - 75 && mouseX <= buttonX + 75
                && mouseY >= cancelButtonY - 20 && mouseY <= cancelButtonY + 20) {
            // Return to initial login state
            setLoginScreenState(LoginScreenState.INITIAL);

            clearCreateAccountFields();
        }

        // Handle keyboard input for create account fields
        handleCreateAccountKeyboardInput();
    }

    /**
     * Attempts to create a new account with the provided information.
     */
    private static void attemptCreateAccount() {
        // Validate input fields
        if (Native.newUsername.length() < 3) {
            setLoginScreenMessage(English.usernameMinLength, "", "");
            return;
        }
        if (Native.newPassword.length() < 5) {
            setLoginScreenMessage(English.passwordMinLength, "", "");
            return;
        }
        // Add more validation as needed (e.g., email format, password strength)

        // TODO: Implement actual account creation logic here
        // This might involve sending a request to the server

        // For now, we'll just show a success message and return to the login screen
        setLoginScreenMessage(English.accountCreationSuccessful, English.youMayNowLogIn, "");
        setLoginScreenState(LoginScreenState.INITIAL);

        clearCreateAccountFields();
    }

    /**
     * Clears the input fields used for account creation.
     */
    private static void clearCreateAccountFields() {
        Native.newUsername = "";
        Native.newPassword = "";
        // Clear any other fields you might have for account creation
    }

    /**
     * Handles keyboard input for the create account fields.
     */
    private static void handleCreateAccountKeyboardInput() {
        while (MovedStatics.method416()) {
            boolean validChar = false;
            char typedChar = (char) MovedStatics.anInt1388;

            // Check if the typed character is valid
            if (Native.supportedCharacters.indexOf(typedChar) != -1) {
                validChar = true;
            }

            // Handle input for username field
            if (loginScreenFocus == 0) {
                if (MovedStatics.anInt2854 == 85 && Native.newUsername.length() > 0) {
                    Native.newUsername = Native.newUsername.substring(0, Native.newUsername.length() - 1);
                }
                if (MovedStatics.anInt2854 == 84 || MovedStatics.anInt2854 == 80) {
                    loginScreenFocus = 1;
                }
                if (validChar && Native.newUsername.length() < 18) {
                    Native.newUsername += typedChar;
                }
            }
            // Handle input for password field
            else if (loginScreenFocus == 1) {
                if (MovedStatics.anInt2854 == 85 && Native.newPassword.length() > 0) {
                    Native.newPassword = Native.newPassword.substring(0, Native.newPassword.length() - 1);
                }
                if (MovedStatics.anInt2854 == 80) {
                    loginScreenFocus = 0;
                }
                if (MovedStatics.anInt2854 == 84) {
                    attemptCreateAccount();
                }
                if (validChar && Native.newPassword.length() < 20) {
                    Native.newPassword += typedChar;
                }
            }
        }
    }

    /**
     * Toggles the music mute state.
     */
    private static void toggleMusicMute() {
        int newVolume = MusicSystem.musicVolume == 0 ? 255 : 0;

        if (newVolume == 0) {
            MusicSystem.method402(false);
            MusicSystem.songTimeout = 0;
        } else {
            MusicSystem.playLoginScreenMusic(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
            MusicSystem.method456(newVolume);
        }

        MusicSystem.musicVolume = newVolume;
        Configuration.setSoundMuted(newVolume == 0);
    }

    /**
     * Attempts to log in with the current username and password.
     */
    private static void attemptLogin() {
        Native.username = Native.username.method62().method85();
        setLoginScreenMessage("", English.connectingToServer, "");
        MovedStatics.processGameStatus(20);
    }

    /**
     * Handles keyboard input for the username and password fields.
     */
    private static void handleLoginKeyboardInput() {
        while (MovedStatics.method416()) {
            boolean validChar = false;

            // Check if the typed character is valid
            for (int i = 0; i < Native.supportedCharacters.length(); i++) {
                if (Native.supportedCharacters.charAt(i) == MovedStatics.anInt1388) {
                    validChar = true;
                    break;
                }
            }

            // Handle input for username field
            if (loginScreenFocus == 0) {
                if (MovedStatics.anInt2854 == 85 && Native.username.length() > 0) {
                    Native.username = Native.username.substring(0, Native.username.length() - 1);
                }
                if (MovedStatics.anInt2854 == 84 || MovedStatics.anInt2854 == 80) {
                    loginScreenFocus = 1;
                }
                if (validChar && Native.username.length() < 18) {
                    Native.username = Native.username.addChar(MovedStatics.anInt1388);
                }
            }
            // Handle input for password field
            else if (loginScreenFocus == 1) {
                if (MovedStatics.anInt2854 == 85 && Native.password.length() > 0) {
                    Native.password = Native.password.substring(0, Native.password.length() - 1);
                }
                if (MovedStatics.anInt2854 == 80) {
                    loginScreenFocus = 0;
                }
                if (MovedStatics.anInt2854 == 84) {
                    attemptLogin();
                }
                if (validChar && Native.password.length() < 20) {
                    Native.password = Native.password.addChar(MovedStatics.anInt1388);
                }
            }
        }
    }


    /**
     * Draws the loading screen, including the login box, flames, and other UI elements.
     * This method handles both fixed and resizable screen modes.
     *
     * @param fontBold  The bold typeface used for text rendering
     * @param fontSmall The small typeface used for text rendering (unused in this method)
     */
    public static void drawLoadingScreen(TypeFace fontBold, TypeFace fontSmall) {
        // Prepare the login box graphics buffer for drawing
        loginBoxGraphics.prepareRasterizer();

        recalculateOffsets();

        // Draw loading progress (game status 0 or 5)
        if (Game.gameStatusCode == 0 || Game.gameStatusCode == 5) {
            int yOffset = 20;
            // Draw "Game is loading" text
            fontBold.drawStringLeft(English.gameIsLoadingPleaseWait, offsetX + 180, offsetY + 74 - yOffset, 16777215);

            // Draw loading bar outline
            int loadingBarY = offsetY + -yOffset + 82;
            Rasterizer.drawUnfilledRectangle(offsetX + 28, loadingBarY, 304, 34, 9179409);
            Rasterizer.drawUnfilledRectangle(offsetX + 29, 1 + loadingBarY, 302, 32, 0);

            // Draw loading bar fill
            Rasterizer.drawFilledRectangle(offsetX + 30, 2 + loadingBarY, Game.gameStartup.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer.drawFilledRectangle(offsetX + 3 * Game.gameStartup.loadingBarPercentage + 30, loadingBarY + 2, -(Game.gameStartup.loadingBarPercentage * 3) + 300, 30, 0);

            // Draw loading status text
            fontBold.drawStringLeft(Game.gameStartup.currentLoadingText, offsetX + 180, offsetY + -yOffset + 105, 16777215);
        }

        // Draw login screen (game status 10)
        if (Game.gameStatusCode == 10) {
            // Draw the login box background
            loginScreenBox.drawImage(0, 0);

            // Draw login messages
            int textY = 40;

            if (loginScreenState == LoginScreenState.INITIAL) {
                fontBold.drawShadowedStringCenter(English.welcomeTo, 180, 40, 16776960, true);
                int i_93_ = 65;
                for (int textIndex = 0; textIndex < English.customLoginText.length; textIndex++) {
                    fontBold.drawShadowedStringCenter(English.customLoginText[textIndex], 180, i_93_, 16777215, true);
                    i_93_ += 15;
                }
            }
            if (loginScreenState != LoginScreenState.INITIAL) {
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineOne, 180, textY, 16776960, true);
                textY += 15;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineTwo, 180, textY, 16776960, true);
                textY += 15;
                fontBold.drawShadowedStringCenter(Native.loginScreenMessageLineThree, 180, textY, 16776960, true);
                textY += 15;
            }


            // Draw username and password fields
            if (loginScreenState == LoginScreenState.LOGIN_INPUT) {
                String starredPassword = Native.password.method61().toString();

                fontBold.drawShadowedString(English.username + Native.username + ((MovedStatics.pulseCycle % 40 < 20 && loginScreenFocus == 0) ? Native.justAnotherYellowBar : ""), 90, textY, true, 16777215);
                textY += 15;
                fontBold.drawShadowedString(English.password + starredPassword + ((MovedStatics.pulseCycle % 40 < 20 && loginScreenFocus == 1) ? Native.justAnotherYellowBar : ""), 92, textY, true, 16777215);
                textY += 15;
            }
            int centerX = 180;
            int buttonWidth = 73;
            int leftButtonCenter = 100;
            int rightButtonCenter = 260;
            // Draw login button
            imgLoginScreenButton.drawImage((loginScreenState == LoginScreenState.INITIAL ? centerX : leftButtonCenter) - buttonWidth,  130);
            fontBold.drawShadowedStringCenter(English.login, (loginScreenState == LoginScreenState.INITIAL ? centerX : leftButtonCenter),  155, 16777215, true);

            // Draw cancel button (for existing user login)
            if (loginScreenState == LoginScreenState.LOGIN_INPUT) {
                imgLoginScreenButton.drawImage(rightButtonCenter - buttonWidth, 130);
                fontBold.drawShadowedStringCenter(English.cancel, rightButtonCenter, 155, 16777215, true);
            }
        }
        if (Configuration.RENDER_FLAMES) {
            renderFlames();
        }
        // Draw the flame backgrounds and other UI elements
        try {


            Graphics graphics = Game.gameCanvas.getGraphics();
            if (MovedStatics.clearScreen) {
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, width, height);
            }

            loginBoxGraphics.drawGraphics(offsetX + 202, offsetY + 171, graphics);
            flameLeftBackground.drawGraphics(offsetX, offsetY, graphics);
            flameRightBackground.drawGraphics(offsetX + 637, offsetY, graphics);

//            // If the screen needs to be fully redrawn
//            if (!MovedStatics.clearScreen)
//                return;

//            MovedStatics.clearScreen = false;

            // Draw additional UI elements
            aProducingGraphicsBuffer_907.drawGraphics(offsetX + 128, offsetY, graphics);
            aProducingGraphicsBuffer_1206.drawGraphics(offsetX + 202, offsetY + 371, graphics);
            aProducingGraphicsBuffer_463.drawGraphics(offsetX, offsetY + 265, graphics);
            aProducingGraphicsBuffer_1285.drawGraphics(offsetX + 562, offsetY + 265, graphics);
            aProducingGraphicsBuffer_2524.drawGraphics(offsetX + 128, offsetY + 171, graphics);
            aProducingGraphicsBuffer_1631.drawGraphics(offsetX + 562, offsetY + 171, graphics);


            // Draw mute button
            drawMuteButton(graphics);

            if (MovedStatics.clearScreen) {
                Game.gameCanvas.repaint();
                MovedStatics.clearScreen = false;
            }
        } catch (Exception exception) {
            // If an error occurs, request a full repaint of the game canvas
            Game.gameCanvas.repaint();
        }
    }

    /**
     * Draws the mute button in the correct position based on the screen mode.
     *
     * @param graphics The graphics context to draw on
     */
    private static void drawMuteButton(Graphics graphics) {
        muteButton.prepareRasterizer();
        ImageRGB musicIcon = TabParts.GetPart("music");

        int muteX, muteY;
        if (ScreenController.frameMode == ScreenMode.RESIZABLE) {
            muteX = ScreenController.drawWidth - 42;
            muteY = ScreenController.drawHeight - 42;
        } else {
            muteX = 723; // Fixed position for the mute button in fixed mode
            muteY = 461; // Fixed position for the mute button in fixed mode
        }

        Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
        Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
        musicIcon.drawImage(4, 3);

        if (MusicSystem.musicVolume == 0) {
            Rasterizer.drawDiagonalLine(0, 0, 42, 42, 0xFF0000);
        }

        muteButton.drawGraphics(muteX, muteY, graphics);
    }

    public static void setLoginScreenMessage(String line1, String line2, String line3) {
        Native.loginScreenMessageLineOne = line1;
        Native.loginScreenMessageLineTwo = line2;
        Native.loginScreenMessageLineThree = line3;
    }

    /**
     * Login screen flames?
     */
    private static void method836(int arg0) {
        int i = 256;
        for (int i_0_ = 10; i_0_ < 117; i_0_++) {
            int i_1_ = (int) (Math.random() * 100.0);
            if (i_1_ < 50)
                anIntArray178[(i - 2 << 7) + i_0_] = 255;
        }
        for (int i_2_ = 0; i_2_ < 100; i_2_++) {
            int i_3_ = (int) (Math.random() * 124.0) + 2;
            int i_4_ = 128 + (int) (Math.random() * 128.0);
            int i_5_ = i_3_ + (i_4_ << 7);
            anIntArray178[i_5_] = 192;
        }
        for (int i_6_ = 1; i_6_ < i - 1; i_6_++) {
            for (int i_7_ = 1; i_7_ < 127; i_7_++) {
                int i_8_ = i_7_ + (i_6_ << 7);
                anIntArray3255[i_8_] = (anIntArray178[i_8_ + 1] + anIntArray178[i_8_ - 1] - (-anIntArray178[-128 + i_8_] - anIntArray178[128 + i_8_])) / 4;
            }
        }
        anInt1641 += 128;
        if (anInt1641 > anIntArray1168.length) {
            anInt1641 -= anIntArray1168.length;
            int i_9_ = (int) (12.0 * Math.random());
            method879(aClass40_Sub5_Sub14_Sub2Array535[i_9_]);
        }
        for (int i_10_ = 1; i_10_ < -1 + i; i_10_++) {
            for (int i_11_ = 1; i_11_ < 127; i_11_++) {
                int i_12_ = i_11_ + (i_10_ << 7);
                int i_13_ = -(anIntArray1168[i_12_ + anInt1641 & -1 + anIntArray1168.length] / 5) + anIntArray3255[i_12_ + 128];
                if (i_13_ < 0)
                    i_13_ = 0;
                anIntArray178[i_12_] = i_13_;
            }
        }
        for (int i_14_ = 0; i_14_ < i + -1; i_14_++)
            anIntArray466[i_14_] = anIntArray466[i_14_ + 1];
        anIntArray466[i - arg0] = (int) (16.0 * Math.sin((double) MovedStatics.pulseCycle / 14.0) + 14.0 * Math.sin((double) MovedStatics.pulseCycle / 15.0) + 12.0 * Math.sin((double) MovedStatics.pulseCycle / 16.0));
        if (anInt2452 > 0)
            anInt2452 -= 4;
        if (anInt2613 > 0)
            anInt2613 -= 4;
        if (anInt2452 == 0 && anInt2613 == 0) {
            int i_15_ = (int) (2000.0 * Math.random());
            if (i_15_ == 0)
                anInt2452 = 1024;
            if (i_15_ == 1)
                anInt2613 = 1024;
        }
    }

    public static void renderLoginScreen(Component arg0, CacheArchive huffmanCacheArchive, CacheArchive gameImageCacheArchive) {
        if (!MovedStatics.aBoolean512) {
            flameLeftBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            flameRightBackground = MovedStatics.createGraphicsBuffer(128, 265, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_907 = MovedStatics.createGraphicsBuffer(509, 171, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_1206 = MovedStatics.createGraphicsBuffer(360, 132, arg0);
            Rasterizer.resetPixels();
            loginBoxGraphics = MovedStatics.createGraphicsBuffer(360, 200, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_463 = MovedStatics.createGraphicsBuffer(202, 238, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_1285 = MovedStatics.createGraphicsBuffer(203, 238, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_2524 = MovedStatics.createGraphicsBuffer(74, 94, arg0);
            Rasterizer.resetPixels();
            aProducingGraphicsBuffer_1631 = MovedStatics.createGraphicsBuffer(75, 94, arg0);
            Rasterizer.resetPixels();
            muteButton = MovedStatics.createGraphicsBuffer(42, 42, arg0);
            Rasterizer.resetPixels();
            byte[] is = huffmanCacheArchive.getFileByName(Native.titleImage, "");
            ImageRGB titleImg = new ImageRGB(is, arg0);
            flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(0, 0);
            flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-637, 0);
            aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(-128, 0);
            aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(-202, -371);
            loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(-202, -171);
            aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(0, -265);
            aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-562, -265);
            aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(-128, -171);
            aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-562, -171);
            int[] is_18_ = new int[titleImg.imageWidth];
            for (int i = 0; i < titleImg.imageHeight; i++) {
                for (int i_19_ = 0; i_19_ < titleImg.imageWidth; i_19_++)
                    is_18_[i_19_] = titleImg.pixels[i * titleImg.imageWidth + titleImg.imageWidth + -i_19_ - 1];
                for (int i_20_ = 0; i_20_ < titleImg.imageWidth; i_20_++)
                    titleImg.pixels[i_20_ + titleImg.imageWidth * i] = is_18_[i_20_];
            }
            flameLeftBackground.prepareRasterizer();
            titleImg.drawInverse(382, 0);
            flameRightBackground.prepareRasterizer();
            titleImg.drawInverse(-255, 0);
            aProducingGraphicsBuffer_907.prepareRasterizer();
            titleImg.drawInverse(254, 0);
            aProducingGraphicsBuffer_1206.prepareRasterizer();
            titleImg.drawInverse(180, -371);
            loginBoxGraphics.prepareRasterizer();
            titleImg.drawInverse(180, -171);
            aProducingGraphicsBuffer_463.prepareRasterizer();
            titleImg.drawInverse(382, -265);
            aProducingGraphicsBuffer_1285.prepareRasterizer();
            titleImg.drawInverse(-180, -265);
            aProducingGraphicsBuffer_2524.prepareRasterizer();
            titleImg.drawInverse(254, -171);
            aProducingGraphicsBuffer_1631.prepareRasterizer();
            titleImg.drawInverse(-180, -171);
            muteButton.prepareRasterizer();
            ImageRGB musicIcon = TabParts.GetPart("music");
            Rasterizer.drawFilledRectangle(0, 0, 42, 42, 0x4d4431);
            Rasterizer.drawUnfilledRectangle(0, 0, 42, 42, 0x242017);
            musicIcon.drawImage(4, 3);
            titleImg = MovedStatics.method1028(gameImageCacheArchive, Native.logo, "");
            aProducingGraphicsBuffer_907.prepareRasterizer();
            // UNCOMMENT LINE UNDER FOR LOGO
            // class40_sub5_sub14_sub4.drawImage(-128 + 382 + -(class40_sub5_sub14_sub4.imageWidth / 2), 18);
            // Comment line under to remove custom logo:
            ImageRGB logo = Images.GetPart("logo");

            logo.drawImage(-128 + 382 + -(logo.imageWidth / 2), 18);

            loginScreenBox = Game.method359(Native.titleBox, "", gameImageCacheArchive);
            imgLoginScreenButton = Game.method359(Native.titleButton, "", gameImageCacheArchive);
            aClass40_Sub5_Sub14_Sub2Array535 = IndexedImage.getMultipleIndexedImages(gameImageCacheArchive, Native.runes, "");

            aClass40_Sub5_Sub14_Sub4_918 = new ImageRGB(128, 265);
            aClass40_Sub5_Sub14_Sub4_2043 = new ImageRGB(128, 265);
            for (int i = 0; i < 33920; i++)
                aClass40_Sub5_Sub14_Sub4_918.pixels[i] = flameLeftBackground.pixels[i];
            for (int i = 0; i < 33920; i++)
                aClass40_Sub5_Sub14_Sub4_2043.pixels[i] = flameRightBackground.pixels[i];
            anIntArray1198 = new int[256];
            for (int i = 0; i < 64; i++)
                anIntArray1198[i] = i * 262144;
            for (int i = 0; i < 64; i++)
                anIntArray1198[64 + i] = 1024 * i + 16711680;
            for (int i = 0; i < 64; i++)
                anIntArray1198[128 + i] = 16776960 + i * 4;
            for (int i = 0; i < 64; i++)
                anIntArray1198[i + 192] = 16777215;
            anIntArray2865 = new int[256];
            for (int i = 0; i < 64; i++)
                anIntArray2865[i] = i * 1024;
            for (int i = 0; i < 64; i++)
                anIntArray2865[i + 64] = 4 * i + 65280;
            for (int i = 0; i < 64; i++)
                anIntArray2865[128 + i] = i * 262144 + 65535;
            for (int i = 0; i < 64; i++)
                anIntArray2865[i + 192] = 16777215;
            anIntArray3248 = new int[256];
            for (int i = 0; i < 64; i++)
                anIntArray3248[i] = i * 4;
            for (int i = 0; i < 64; i++)
                anIntArray3248[64 + i] = 255 + i * 262144;
            for (int i = 0; i < 64; i++)
                anIntArray3248[128 + i] = i * 1024 + 16711935;
            for (int i = 0; i < 64; i++)
                anIntArray3248[192 + i] = 16777215;
            anIntArray1013 = new int[256];
            anIntArray1445 = new int[32768];
            anIntArray1168 = new int[32768];
            method879(null);
            anIntArray3255 = new int[32768];
            Native.username = Configuration.getUsername();
            Native.password = Configuration.getPassword();
            anIntArray178 = new int[32768];
            setLoginScreenState(LoginScreenState.INITIAL);

            if (MusicSystem.musicVolume != 0 && !VertexNormal.lowMemory)
                MusicSystem.playLoginScreenMusic(false, CacheArchive.musicCacheArchive, 0, Native.titleSong, 10, "", MusicSystem.musicVolume);
            else
                MusicSystem.method405(10);
            Game.updateServerConnectionManager.updateServer.resetRequests(false);
            MovedStatics.clearScreen = true;
            MovedStatics.aBoolean512 = true;
        }
    }

    public static void method879(IndexedImage arg1) {
        int i = 0;
        for (/**/; i < anIntArray1168.length; i++)
            anIntArray1168[i] = 0;
        int i_19_ = 256;
        for (int i_20_ = 0; i_20_ < 5000; i_20_++) {
            int i_21_ = (int) ((double) i_19_ * (128.0 * Math.random()));
            anIntArray1168[i_21_] = (int) (256.0 * Math.random());
        }
        for (int i_22_ = 0; i_22_ < 20; i_22_++) {
            for (int i_23_ = 1; -1 + i_19_ > i_23_; i_23_++) {
                for (int i_24_ = 1; i_24_ < 127; i_24_++) {
                    int i_25_ = (i_23_ << 7) + i_24_;
                    anIntArray1445[i_25_] = (anIntArray1168[i_25_ - 128] + anIntArray1168[i_25_ + -1] + anIntArray1168[i_25_ + 1] + anIntArray1168[128 + i_25_]) / 4;
                }
            }
            int[] is = anIntArray1168;
            anIntArray1168 = anIntArray1445;
            anIntArray1445 = is;
        }
        if (arg1 != null) {
            int i_26_ = 0;
            for (int i_27_ = 0; arg1.imgHeight > i_27_; i_27_++) {
                for (int i_28_ = 0; i_28_ < arg1.imgWidth; i_28_++) {
                    if (arg1.imgPixels[i_26_++] != 0) {
                        int i_29_ = arg1.yDrawOffset + i_27_ + 16;
                        int i_30_ = arg1.xDrawOffset + i_28_ + 16;
                        int i_31_ = i_30_ + (i_29_ << 7);
                        anIntArray1168[i_31_] = 0;
                    }
                }
            }
        }
    }

    public static void renderFlames() {
        if (anInt2452 <= 0) {
            if (anInt2613 > 0) {
                for (int i = 0; i < 256; i++) {
                    if (anInt2613 > 768)
                        anIntArray1013[i] = method614(anIntArray1198[i], anIntArray3248[i], -anInt2613 + 1024);
                    else if (anInt2613 > 256)
                        anIntArray1013[i] = anIntArray3248[i];
                    else
                        anIntArray1013[i] = method614(anIntArray3248[i], anIntArray1198[i], -anInt2613 + 256);
                }
            } else {
                System.arraycopy(anIntArray1198, 0, anIntArray1013, 0, 256);
            }
        } else {
            for (int i = 0; i < 256; i++) {
                if (anInt2452 <= 768) {
                    if (anInt2452 > 256)
                        anIntArray1013[i] = anIntArray2865[i];
                    else
                        anIntArray1013[i] = method614(anIntArray2865[i], anIntArray1198[i], -anInt2452 + 256);
                } else
                    anIntArray1013[i] = method614(anIntArray1198[i], anIntArray2865[i], -anInt2452 + 1024);
            }
        }
        int i = 256;
        System.arraycopy(aClass40_Sub5_Sub14_Sub4_918.pixels, 0, flameLeftBackground.pixels, 0, 33920);
        int i_61_ = 0;
        int i_62_ = 1152;
        for (int i_63_ = 1; i - 1 > i_63_; i_63_++) {
            int i_64_ = (-i_63_ + i) * anIntArray466[i_63_] / i;
            int i_65_ = i_64_ + 22;
            if (i_65_ < 0)
                i_65_ = 0;
            i_61_ += i_65_;
            for (int i_66_ = i_65_; i_66_ < 128; i_66_++) {
                int i_67_ = anIntArray178[i_61_++];
                if (i_67_ != 0) {
                    int i_68_ = -i_67_ + 256;
                    int i_69_ = i_67_;
                    i_67_ = anIntArray1013[i_67_];
                    int i_70_ = flameLeftBackground.pixels[i_62_];
                    flameLeftBackground.pixels[i_62_++] = BitUtils.bitWiseAND(-16711936, BitUtils.bitWiseAND(i_67_, 16711935) * i_69_ + i_68_ * BitUtils.bitWiseAND(i_70_, 16711935)) + BitUtils.bitWiseAND(BitUtils.bitWiseAND(65280, i_70_) * i_68_ + i_69_ * BitUtils.bitWiseAND(65280, i_67_), 16711680) >> 8;
                } else
                    i_62_++;
            }
            i_62_ += i_65_;
        }
        i_62_ = 1176;
        i_61_ = 0;

        for (int i_71_ = 0; i_71_ < 33920; i_71_++)
            flameRightBackground.pixels[i_71_] = aClass40_Sub5_Sub14_Sub4_2043.pixels[i_71_];
        for (int i_72_ = 1; i_72_ < -1 + i; i_72_++) {
            int i_73_ = (-i_72_ + i) * anIntArray466[i_72_] / i;
            int i_74_ = 103 + -i_73_;
            i_62_ += i_73_;
            for (int i_75_ = 0; i_75_ < i_74_; i_75_++) {
                int i_76_ = anIntArray178[i_61_++];
                if (i_76_ != 0) {
                    int i_77_ = i_76_;
                    int i_78_ = flameRightBackground.pixels[i_62_];
                    int i_79_ = 256 + -i_76_;
                    i_76_ = anIntArray1013[i_76_];
                    flameRightBackground.pixels[i_62_++] = BitUtils.bitWiseAND(i_77_ * BitUtils.bitWiseAND(65280, i_76_) + i_79_ * BitUtils.bitWiseAND(65280, i_78_), 16711680) + BitUtils.bitWiseAND(i_79_ * BitUtils.bitWiseAND(16711935, i_78_) + BitUtils.bitWiseAND(16711935, i_76_) * i_77_, -16711936) >> 8;
                } else
                    i_62_++;
            }
            i_62_ += 128 - (i_74_ + i_73_);
            i_61_ += -i_74_ + 128;
        }
    }

    public static int method614(int arg1, int arg2, int arg3) {
        int i_7_ = 256 + -arg3;
        return (arg3 * (0xff00 & arg2) + i_7_ * (0xff00 & arg1) & 0xff0000) + (~0xff00ff & (0xff00ff & arg1) * i_7_ + arg3 * (0xff00ff & arg2)) >> 8;
    }

    public static void displayMessageForResponseCode(int responseCode) {
        if (responseCode == -3) {
            setLoginScreenMessage(English.connectionTimedOut, English.pleaseTryUsingDifferentWorld, "");
        } else if (responseCode == -2) {
            setLoginScreenMessage("", English.errorConnectingToServer, "");
        } else if (responseCode == -1) {
            setLoginScreenMessage(English.noResponseFromServer, English.pleaseTryUsingDifferentWorld, "");
        } else if (responseCode == 3) {
            setLoginScreenMessage("", English.invalidUsernameOrPassword, "");
        } else if (responseCode == 4) {
            setLoginScreenMessage(English.yourAccountHasBeenDisabled, English.pleaseCheckYourMessageCenterForDetails, "");
        } else if (responseCode == 5) {
            setLoginScreenMessage(English.yourAccountIsAlreadyLoggedIn, English.tryAgainIn60Secs, "");
        } else if (responseCode == 6) {
            setLoginScreenMessage(English.gameHasBeenUpdated, English.pleaseReloadThisPage, "");
        } else if (responseCode == 7) {
            setLoginScreenMessage(English.theWorldIsFull, English.pleaseUseADifferentWorld, "");
        } else if (responseCode == 8) {
            setLoginScreenMessage(English.unableToConnect, English.loginServerOffline, "");
        } else if (responseCode == 9) {
            setLoginScreenMessage(English.loginLimitExceeded, English.tooManyConnectionsFromYourAddress, "");
        } else if (responseCode == 10) {
            setLoginScreenMessage(English.unableToConnect, English.badSessionId, "");
        } else if (responseCode == 11) {
            setLoginScreenMessage(English.weSuspectSomeoneKnowsYourPassword, English.pressChangeYourPasswordOnFrontPage, "");
        } else if (responseCode == 12) {
            setLoginScreenMessage(English.youNeedMembersAccountToLoginToThisWorld, English.pleaseSubscribeOrUseDifferentWorld, "");
        } else if (responseCode == 13) {
            setLoginScreenMessage(English.couldNotCompleteLogin, English.pleaseTryUsingDifferentWorld, "");
        } else if (responseCode == 14) {
            setLoginScreenMessage(English.theServerIsBeingUpdated, English.pleaseWait1MinuteAndTryAgain, "");
        } else if (responseCode == 16) {
            setLoginScreenMessage(English.tooManyIncorrectLoginsFromYourAddress, English.pleaseWait5MinutesBeforeTryingAgain, "");
        } else if (responseCode == 17) {
            setLoginScreenMessage(English.youAreStandingInMembersOnlyArea, English.toPlayOnThisWorldMoveToFreeArea, "");
        } else if (responseCode == 18) {
            setLoginScreenMessage(English.accountLockedAsWeSuspectItHasBeenStolen, English.pressRecoverLockedAccountOnFrontPage, "");
        } else if (responseCode == 20) {
            setLoginScreenMessage(English.invalidLoginserverRequested, English.pleaseTryUsingDifferentWorld, "");
        } else if (responseCode == 22) {
            setLoginScreenMessage(English.malformedLoginPacket, English.pleaseTryAgain, "");
        } else if (responseCode == 23) {
            setLoginScreenMessage(English.noReplyFromLoginserver, English.pleaseWait1MinuteAndTryAgain, "");
        } else if (responseCode == 24) {
            setLoginScreenMessage(English.errorLoadingYourProfile, English.pleaseContactCustomerSupport, "");
        } else if (responseCode == 25) {
            setLoginScreenMessage(English.unexpectedLoginserverResponse, English.pleaseTryUsingDifferentWorld, "");
        } else if (responseCode == 26) {
            setLoginScreenMessage(English.thisComputersAddressHasBeenBlocked, English.asItWasUsedToBreakOurRules, "");
        } else if (responseCode == 27) {
            setLoginScreenMessage("", English.serviceUnavailable, "");
        } else {
            setLoginScreenMessage(English.unexpectedServerResponse, English.pleaseTryUsingDifferentWorld, "");
        }
        MovedStatics.processGameStatus(10);
    }
}
