twitter-topics-analyzer
=======================

Team #2

h2. API

```
In 
/api/{pairId}
Output from Twitter Collector

Out
{
    “pairId” : 1,
    “places” :
    [
            {
            "place" :
            {
                "name":"Washington",
                "country_code": "US"
            },
            "probability" : "high",
            "origin" : "twitter_place"
            },
            {
            "place" :
            {
                "name":"Warsaw",
                "country_code": "PL"
            },
            "probability" : "high",
            "origin" : "twitter_mention"
            }
    ]
}
```
