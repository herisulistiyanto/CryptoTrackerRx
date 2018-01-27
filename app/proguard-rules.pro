# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-verbose
-optimizationpasses 5

-dontwarn com.android.**
-dontwarn com.squareup.**
-dontwarn okio.**
-dontwarn retrofit2.**
-dontwarn rx.**
-dontwarn com.google.**
-dontwarn android.support.**
-dontwarn java.lang.invoke.*
-dontwarn javax.annotation.**
-dontwarn javax.inject.**
-dontwarn sun.misc.Unsafe
-dontwarn org.slf4j.**

-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes Exceptions
-keepattributes EnclosingMethod
-keepattributes Deprecated

#COMMON JAVA
-keepnames class * implements java.io.Serializable { *;}
-keep class java.util.** { *; }
-keep class javax.inject.* { *; }

#ANDROID_COMPONENT
-keep class android.support.v7.widget.LinearLayoutManager {
    public protected *;
}
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }
-keep class android.support.v7.widget.** { *; }
-keep public class * extends android.app.Activity
-keep public class * extends android.support.v7.app.AppCompatActivity
-keep public class * extends android.support.v7.widget.** { *;}
-keep interface android.support.v7.** { *; }
-keep class android.support.v7.** { *; }
-keep interface android.support.v4.** { *; }
-keep class android.support.v4.** { *; }
-keep class android.net.http.** { *; }
-keepclassmembers class android.net.http.** { *; }
-keep class android.support.** {
   public protected private *;
 }
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service {
*;
}
-keep public class * extends android.support.v4.app.Fragment
-keepclasseswithmembernames class * {
   native <methods>;
}
-keepclassmembers class **.R$* {
   public static <fields>;
}
-keepattributes InnerClasses
-keep class **.R
-keep class **.R$* {
    <fields>;
}
-keepclasseswithmembers class * {
   public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * {
   public void *ButtonClicked(android.view.View);
}
-keepclassmembers class android.os.Environment
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
-keepnames class * implements java.io.Serializable { *;}
-keep class android.telephony.** { *; }
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keep class android.support.constraint.** { *; }

#DAGGER
-dontwarn dagger.internal.codegen.**
-keepclassmembers,allowobfuscation class * {
    @javax.inject.* *;
    @dagger.* *;
    <init>();
}
-keep class **$$ModuleAdapter
-keep class **$$InjectAdapter
-keep class **$$StaticInjection
-dontnote dagger.Lazy
-keepnames class dagger.Lazy

#OKIO
-keep class sun.misc.Unsafe { *; }
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**

#OKHTTP
-keepattributes *Annotation*
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**

#OKHTTP3
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

#RETROFIT
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-dontnote retrofit2.Platform
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8
-dontwarn retrofit.RxSupport*
-dontwarn retrofit.appengine.UrlFetchClient
-dontnote retrofit.http.RestMethod
-keepclasseswithmembers class * {
    @retrofit2.* <methods>;
}
-keepclasseswithmembers interface * {
    @retrofit2.* <methods>;
}

#GSON
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.* { *; }
-keep public class com.google.gson.** {
    public private protected *;
}
-keep class com.google.appengine.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keep class com.google.gson.* { *; }
-keep class com.google.inject.* { *; }
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keepclassmembers enum * { *; }
-keep,allowobfuscation @interface com.google.gson.annotations.*
-dontnote com.google.gson.annotations.Expose
-keepclassmembers class * {
    @com.google.gson.annotations.Expose <fields>;
}
-keepclasseswithmembers,allowobfuscation,includedescriptorclasses class * {
    @com.google.gson.annotations.Expose <fields>;
}
-dontnote com.google.gson.annotations.SerializedName
-keepclasseswithmembers,allowobfuscation,includedescriptorclasses class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
-keepclassmembers enum * {
    @com.google.gson.annotations.SerializedName <fields>;
}