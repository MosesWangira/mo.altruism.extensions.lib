# mo.altruism.extensions.lib
[![](https://jitpack.io/v/MosesWangira/mo.altruism.extensions.lib.svg)](https://jitpack.io/#MosesWangira/mo.altruism.extensions.lib)


## Description
A library containing extensions commonly used in android

## Download 

### Using gradle
In your root build.gradle at the end of repositories add
```
allprojects {
 	repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
```

Add the dependency<br/>
Current Version is v1.0.0 (Make sure to check if its the current version)

```
dependencies {
    implementation 'com.github.MosesWangira:mo.altruism.extensions.lib:v1.0.0'
}
```

### Using maven
Add the JitPack repository to your build file

```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

Add the dependency

```
dependency>
	<groupId>com.github.MosesWangira</groupId>
	<artifactId>mo.altruism.extensions.lib</artifactId>
	<version>v1.0.0</version>
</dependency>
```

## How to use the library
### Views
Toast
```
requireContext().toast("your message")
```
SnackBar 
```
View.snackBar("message")

View.snackBarAction("message", "actionMessage") //snack bar with action message

//int inside bracket means the value passed is an int
View.snackBarAction("message, "actionMessage", context, textColor(Int), backgroundColor(Int)) 
```
Change status bar color
```
//In an activity
changeStatusBarColor("#FFFFFF") //enter hexcode for your preffered color
requireActivity().changeStatusBarColor("#FFFFFF") //In a fragment
```
View visibility
```
View.visible() //make it visible
View.visible() //make it gone
```
Hide soft keyboard
```
Activity.hideSoftKeyBoard() //In activity
requireActivity.hideSoftKeyBoard() //In fragment
```
