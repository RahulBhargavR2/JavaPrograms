package codingChallenge.heap;



import java.util.*;
//
//public class DesignTwitter {
//    class Tweet implements Comparable<Tweet>{
//        int tweetId;
//        long time;
//
//        public Tweet(int tweetId) {
//            this.tweetId = tweetId;
//            this.time = System.nanoTime();
//        }
//
//        @Override
//        public int compareTo(@NotNull Tweet o) {
//            return Long.compare(o.time,this.time);
//        }
//    }
//    Map<Integer, Set<Integer>> followers;
//    Map<Integer,ArrayList<Tweet>> tweets;
//    public DesignTwitter() {
//        followers = new HashMap<>();
//        tweets = new HashMap<>();
//    }
//
//    public void postTweet(int userId, int tweetId) {
//        if (!tweets.containsKey(userId))
//            tweets.put(userId,new ArrayList<>());
//        tweets.get(userId).add(new Tweet(tweetId));
//    }
//
//    public List<Integer> getNewsFeed(int userId) {
//        List<Integer> result = new ArrayList<>();
//
//        PriorityQueue<Tweet> heap = new PriorityQueue<>();
//        Set<Integer> followeeSet = new HashSet<>();
//        if (followers.containsKey(userId)&&!followers.get(userId).isEmpty())
//            followeeSet.addAll(followers.get(userId));
//        followeeSet.add(userId);
//
//        for(int followee: followeeSet){
//            for (int i=tweets.get(followee).size()-1,j=0;i>=0&&j<10;i--,j++)
//                heap.add(tweets.get(followee).get(i));
//        }
//        for(int i=0;i<10&&!heap.isEmpty();i++)
//            result.add(heap.poll().tweetId);
//        System.out.println(result);
//        return result;
//    }
//
//    public void follow(int followerId, int followeeId) {
//
//        if (followerId==followeeId)
//            return;
//        if (!followers.containsKey(followerId))
//            followers.put(followerId,new HashSet<>());
//        followers.get(followerId).add(followeeId);
//    }
//
//    public void unfollow(int followerId, int followeeId) {
//        followers.get(followerId).remove(followeeId);
//    }
//
//    public static void main(String[] args) {
//        DesignTwitter twitter = new DesignTwitter();
//        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
//        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
//        twitter.follow(1, 2);    // User 1 follows user 2.
//        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
//        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
//        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
//
//    }
//}

public class DesignTwitter {
    Map<Integer, Set<Integer>> followData;
    List<int[]> tweets;
    public DesignTwitter() {
        followData = new HashMap<>();
        tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(followData.get(userId)==null){
            Set<Integer> followList = new HashSet<>();
            followList.add(userId);
            followData.put(userId, followList);
        }
        tweets.add(new int[]{userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // for(int[] tweet:tweets){
        //     System.out.print(tweet[0]+" "+tweet[1]+",");
        // }
        // System.out.println();
        List<Integer> recentTweets = new ArrayList<>();
        int i=10;
        int tweetCounter = tweets.size()-1;
        Set<Integer> followingList = followData.get(userId);
        while(i>0 && tweetCounter>=0 && followingList!=null){
            if(followingList.contains(tweets.get(tweetCounter)[0])){
                recentTweets.add(tweets.get(tweetCounter)[1]);
                i--;
            }
            tweetCounter--;

        }
        return recentTweets;
    }

    public void follow(int followerId, int followeeId) {
        if(followData.get(followeeId)==null || followData.get(followerId)==null){
            Set<Integer> followList = new HashSet<>();
            followList.add(followerId);
            followList.add(followeeId);
            followData.put(followerId, followList);
        } else{
            followData.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        for(int followee: followData.get(followerId)){
            if(followee==followeeId){
                followData.get(followerId).remove(followeeId);
                break;
            }
        }

    }
}