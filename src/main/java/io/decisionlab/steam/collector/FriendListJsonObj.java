package io.decisionlab.steam.collector;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * io.decisionlab.steam.collector
 * Created by nathan on 2/29/2016.
 */
public class FriendListJsonObj {

        @SerializedName("friendslist")
        @Expose
        private FriendList friendslist;

        /**
         *
         * @return
         * The friendslist
         */
        public FriendList getFriendslist() {
            return friendslist;
        }

        /**
         *
         * @param friendslist
         * The friendslist
         */
        public void setFriendslist(FriendList friendslist) {
            this.friendslist = friendslist;
        }

}
