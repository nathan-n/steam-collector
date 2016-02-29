package io.decisionlab.steam.collector;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * io.decisionlab.steam.collector
 * Created by nathan on 2/29/2016.
 */
public class FriendList {
    @SerializedName("friends")
    @Expose
    private List<Friend> friends = new ArrayList<Friend>();

    /**
     *
     * @return
     * The friends
     */
    public List<Friend> getFriends() {
        return friends;
    }

    /**
     *
     * @param friends
     * The friends
     */
    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
