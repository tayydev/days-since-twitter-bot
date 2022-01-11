package tech.nathann.daysSinceTwitter

import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import twitter4j.createTweet
import java.nio.file.Files
import java.nio.file.Path
import java.time.*
import java.time.format.DateTimeFormatter

fun main() {
    //keys
    val (
        consumerKey,
        consumerSecret,
        accessToken,
        accessSecret,
        dateString,
        message
    ) = keys("./keys.txt")

    //setup twitter
    val cb = ConfigurationBuilder()
    cb.setDebugEnabled(true)
        .setOAuthConsumerKey(consumerKey)
        .setOAuthConsumerSecret(consumerSecret)
        .setOAuthAccessToken(accessToken)
        .setOAuthAccessTokenSecret(accessSecret)
    val factory = TwitterFactory(cb.build())
    val twitter: Twitter = factory.instance!!

    //read date from keys
    val date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE).atTime(LocalTime.MIDNIGHT)
    val zoned = ZonedDateTime.of(date, ZoneId.of("US/Eastern"))

    //run service
    service(twitter, zoned, message)
}

fun service(twitter: Twitter, original: ZonedDateTime, message: String) {
    println("Starting service!")
    while(true) {
        val now = ZonedDateTime.now(ZoneId.of("US/Eastern"))
        println("Running hourly check - Hour is ${now.hour}")
        if(now.hour == 12) {
            println("Is noon - Trying to tweet")
            val days = Duration.between(original, now).toDays()
            val text = message.replace("%DAYS%", days.toString())

            twitter.createTweet(
                text = text
            )
        }
        Thread.sleep(Duration.ofHours(1).toMillis())
    }
}

fun keys(path: String): List<String> = Files.readAllLines(Path.of(path)).filter { it[0] != '#' }

operator fun <E> List<E>.component6(): E = this[5] //lmao