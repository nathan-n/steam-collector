package io.decisionlab.steam.collector;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * io.decisionlab.steam.collector
 * Created by nathan on 2/29/2016.
 */
public class Friend {
    @SerializedName("steamid")
    @Expose
    private String steamid;
    @SerializedName("relationship")
    @Expose
    private String relationship;
    @SerializedName("friend_since")
    @Expose
    private Long friendSince;

    /**
     *
     * @return
     * The steamid
     */
    public String getSteamid() {
        return steamid;
    }

    /**
     *
     * @param steamid
     * The steamid
     */
    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    /**
     *
     * @return
     * The relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     *
     * @param relationship
     * The relationship
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     *
     * @return
     * The friendSince
     */
    public Long getFriendSince() {
        return friendSince;
    }

    /**
     *
     * @param friendSince
     * The friend_since
     */
    public void setFriendSince(Long friendSince) {
        this.friendSince = friendSince;
    }
}
