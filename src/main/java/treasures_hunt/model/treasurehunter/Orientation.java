package treasures_hunt.model.treasurehunter;

// An enum that represents the cardinal points.
public enum Orientation {
    N("NORTH"), E("EAST"), S("SOUTH"), W("WEST");

    private final String cardinalite;

    Orientation(String cardinalite) {
        this.cardinalite = cardinalite;
    }

    public String getCardinalite() {
        return cardinalite;
    }

}
