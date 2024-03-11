package com.dicoding.finalfantasyvii

import android.os.Parcel
import android.os.Parcelable

data class Character(
    val name: String?,
    val age: String?,
    val occupation: String?,
    val photo: String?,
    val description: String?,
    val home : String?,
    val affiliation : String?,
    val race: String?,
    val gender: String?,
    val height : String?,
    val hair_color : String?,
    val eye_color : String?,
    val blood_type : String?,
    val weapon : String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(occupation)
        parcel.writeString(photo)
        parcel.writeString(description)
        parcel.writeString(home)
        parcel.writeString(affiliation)
        parcel.writeString(race)
        parcel.writeString(gender)
        parcel.writeString(height)
        parcel.writeString(hair_color)
        parcel.writeString(eye_color)
        parcel.writeString(blood_type)
        parcel.writeString(weapon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}