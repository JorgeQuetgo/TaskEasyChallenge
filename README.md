# TaskEasyChallenge

### what have I used
I made the challenge in Java with Spring boot, building a  RESTful Web Service

* IDE IntelliJ IDEA
* JDK 1.8
* Maven


## Endpoints

### Initialize data from Collaborators:

* Post 
* Header Content-Type : application/json
* link: `http://domain:port/initialize_collaborators`

####data:
```json 
[
  	{
  		"name": "Kyle",
  		"meetingSchedule": ["13:30:00", "14:30:00", "18:00"]
  	},
  	{
  		"name": "Paul",
  		"meetingSchedule": ["07:00:00", "09:00:00", "13:30:00", "15:00:00", "15:30:00"]		
  	},
  	{
  		"name": "Alex",
  		"meetingSchedule": ["08:00:00", "09:30:00", "13:30:00", "15:00:00"]
  	},
  	{
  		"name": "Luis",
  		"meetingSchedule": ["09:00:00", "13:30:00", "15:00:00", "15:30:00"]		
  	},
  	{
  		"name": "Jairo",
  		"meetingSchedule": ["08:00:00", "09:00:00", "18:00:00"]
  	},
  	{
  		"name": "Sonya",
  		"meetingSchedule": ["08:00:00", "12:30:00", "13:30:00", "15:30:00"]		
  	}
  ] 
```

### get data from collaborators:
* Get 
* link: `http://domain:port/collaborators`

### Initialize data from Working hours:
* Post 
* Header Content-Type : application/json
* link: `http://domain:port/initialize_working_hours`

####data:
```json 
    {
        "entryTime": "08:00:00",
        "departureTime": "17:00:00",
        "lunchEntryTime": "12:00:00",
        "lunchDepartureTime": "13:00:00"
    }
```

### get data from working hours:
* Get 
* link: `http://domain:port/working_hours`

## test one time:
enter as input the time to verify
* Post 
* Header Content-Type : application/json
* link: `http://domain:port/retrieve_free_collaborators`

####data:
```json 
{
	"time": "08:30:00"
}
```
return:
at least three people are available

example:
```json 
[
    "Kyle",
    "Paul",
    "Alex",
    "Luis",
    "Jairo",
    "Sonya"
]
```

