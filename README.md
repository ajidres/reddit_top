# Android Movies Application

Android app to see top feed from reddit 


## Installation
Clone this repository and import into **Android Studio**
```bash
https://github.com/ajidres/reddit_top
```

## Configuration
### Keystores:
Create a file `app/secrets.properties` with the following info:
```gradle
STATE= -> Constant to oauth request 
URL_BASE=https://www.reddit.com/api/v1/
URL_BASE_OAUTH=https://oauth.reddit.com/
CLIENT_ID= -> You must create a project in reddit dev portal (https://www.reddit.com/dev/api/) and create an app from type **Installed app**  
REDIRECT_URI= -> When you created the app in the dev page you setted an redirect url for the app, put here that url
```

## Generating debug APK
From Android Studio:
1. ***Build*** menu
2. Build Bundle(s)/APK(s)

## Generating signed APK
From Android Studio:
1. ***Build*** menu
2. ***Generate Signed Bundle/APK...***
3. Fill in the keystore information *(you only need to do this once manually and then let Android Studio remember it)*

## Maintainers
This project is mantained by:
* [Andres Jimenez](https://github.com/ajidre)
