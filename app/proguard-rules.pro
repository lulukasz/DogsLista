-keepattributes *Annotation*
-keep class androidx.room.** { *; }
-keep class com.google.gson.** { *; }
-keepclassmembers class ** {
    @com.google.gson.annotations.SerializedName <fields>;
}
-dontwarn retrofit2.**
