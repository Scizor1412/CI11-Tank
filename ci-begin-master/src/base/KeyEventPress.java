package base;

public class KeyEventPress {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isAnyKeyPress;
    public static boolean isPauseKeyPress;
    public static boolean isReturnKeyPress;

    public static boolean keyMovePress() {
        return isUpPress || isDownPress || isLeftPress || isRightPress;
    }
}
