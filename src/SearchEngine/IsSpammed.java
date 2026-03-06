package SearchEngine;

public class IsSpammed implements SpamBehavior {

    @Override
    public SpamResult check(String content) {
        return new SpamResult(true, 1.0, "Blocked by Strict Policy (IsSpammed)");
    }
}