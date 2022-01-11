package tech.nathann.daysSinceTwitter

import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import twitter4j.createTweet

private val keys = Keys("./keys.txt")
fun main() {
    val cb = ConfigurationBuilder()
    cb.setDebugEnabled(true)
        .setOAuthConsumerKey(keys[0])
        .setOAuthConsumerSecret(keys[1])
        .setOAuthAccessToken(keys[2])
        .setOAuthAccessTokenSecret(keys[3])
    val factory = TwitterFactory(cb.build())
    val twitter: Twitter = factory.instance!!

    twitter.createTweet(
        text = "Testing...part 3"
    )
}