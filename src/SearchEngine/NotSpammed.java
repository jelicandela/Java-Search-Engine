package SearchEngine;

public class NotSpammed implements SpamBehavior {

    @Override
    public SpamResult check(String content) {
        return new SpamResult(false, 0.0, "Safe (NotSpammed)");
    }
}
