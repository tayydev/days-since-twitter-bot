# days-since-twitter-bot
This project is a simple script that tweets daily with the number of days that have occurred since a given date.

For example, I use this bot to run the @YoruBuffs Twitter account that tracks the number of days since the VALORANT character Yoru has been patched:
![](yoru%20buffs.PNG)
# usage
Compile with Gradle and create a keys.txt matching the following format:
```bash
#api key
[YOUR KEY HERE]
#api secret
[YOUR KEY HERE]
#oauth key
[YOUR KEY HERE]
#oauth secret
[YOUR KEY HERE]
#date
[yyyy-mm-dd]
#message
[TWEET MESSAGE HERE. eg. "It has be %DAYS% since last summer"]
```