import java.sql.Timestamp;
import java.util.*;

class Twitter {
  Map<Integer, User> hashMap;
  static int date = 0;
  /** Initialize your data structure here. */
  public Twitter() {
    hashMap = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    User user;
    if (hashMap.containsKey(userId)) {
      user = hashMap.get(userId);
    } else {
      user = new User(userId);
      hashMap.put(userId, user);
    }
    Twi twi = new Twi(tweetId, date++);
    user.twis.add(twi);
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    User user = hashMap.get(userId);
    if (user == null) return new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    PriorityQueue<Twi> queue =
        new PriorityQueue<>(
            10,
            new Comparator<Twi>() {
              @Override
              public int compare(Twi o1, Twi o2) {
                return -o1.date + o2.date;
              }
            });
    for (int fid : user.follows) {
      User f = hashMap.get(fid);
      queue.addAll(f.twis);
    }
    for (int i = 0; i < 10; i++) {
      if (!queue.isEmpty()) list.add(queue.poll().id);
    }
    return list;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
      if(followeeId==followerId)
          return;

    User user = hashMap.get(followerId);
    if (user == null) {
      user = new User(followerId);
      hashMap.put(followerId, user);
    }
    user.follows.add(followeeId);
    User fo = hashMap.get(followeeId);
    if (fo == null) {
      fo = new User(followeeId);
      hashMap.put(followeeId, fo);
    }
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
      if(followeeId==followerId)
          return;

      User user = hashMap.get(followerId);
    if (user == null) return;
    user.follows.remove(followeeId);
  }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId); List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */
class User {
  public int id;
  public Set<Integer> follows;
  public List<Twi> twis;

  public User() {
    follows = new HashSet<>();
    this.twis = new LinkedList<>();
  }

  public User(int id) {
    this.id = id;
    this.follows = new HashSet<>();
    this.twis = new LinkedList<>();
    follows.add(id);
  }
}

class Twi {
  public int id;
  public int date;

  public Twi() {}

  public Twi(int id, int date) {
    this.id = id;
    this.date = date;
  }
}
