package org.Housing.KCAgentList.models;

public enum StatusType {

    INLISTING("In Listing"),
    COMINGSOON("Coming Soon"),
    PENDINGCONTRACT("Contact Email"),
    SOLD("Sold");

    private final String displayName;

    StatusType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
