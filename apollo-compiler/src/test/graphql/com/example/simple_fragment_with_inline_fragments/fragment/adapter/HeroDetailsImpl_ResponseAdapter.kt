// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_fragment_with_inline_fragments.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.simple_fragment_with_inline_fragments.fragment.HeroDetailsImpl
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.collections.List

object HeroDetailsImpl_ResponseAdapter : ResponseAdapter<HeroDetailsImpl> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null),
    ResponseField.forString("name", "name", null, false, null),
    ResponseField.forList("friends", "friends", null, true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HeroDetailsImpl {
    return reader.run {
      var __typename: String? = __typename
      var name: String? = null
      var friends: List<HeroDetailsImpl.Friend?>? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> name = readString(RESPONSE_FIELDS[1])
          2 -> friends = readList<HeroDetailsImpl.Friend>(RESPONSE_FIELDS[2]) { reader ->
            reader.readObject<HeroDetailsImpl.Friend> { reader ->
              Friend.fromResponse(reader)
            }
          }
          else -> break
        }
      }
      HeroDetailsImpl(
        __typename = __typename!!,
        name = name!!,
        friends = friends
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeString(RESPONSE_FIELDS[1], value.name)
    writer.writeList(RESPONSE_FIELDS[2], value.friends) { values, listItemWriter ->
      values?.forEach { value ->
        if(value == null) {
          listItemWriter.writeObject(null)
        } else {
          listItemWriter.writeObject { writer ->
            Friend.toResponse(writer, value)
          }
        }
      }
    }
  }

  object Friend : ResponseAdapter<HeroDetailsImpl.Friend> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): HeroDetailsImpl.Friend {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "Human" -> HumanFriend.fromResponse(reader, typename)
        "Droid" -> DroidFriend.fromResponse(reader, typename)
        else -> OtherFriend.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Friend) {
      when(value) {
        is HeroDetailsImpl.Friend.HumanFriend -> HumanFriend.toResponse(writer, value)
        is HeroDetailsImpl.Friend.DroidFriend -> DroidFriend.toResponse(writer, value)
        is HeroDetailsImpl.Friend.OtherFriend -> OtherFriend.toResponse(writer, value)
      }
    }

    object HumanFriend : ResponseAdapter<HeroDetailsImpl.Friend.HumanFriend> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null),
        ResponseField.forDouble("height", "height", null, true, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Friend.HumanFriend {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var height: Double? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> height = readDouble(RESPONSE_FIELDS[2])
              else -> break
            }
          }
          HeroDetailsImpl.Friend.HumanFriend(
            __typename = __typename!!,
            name = name!!,
            height = height
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Friend.HumanFriend) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeDouble(RESPONSE_FIELDS[2], value.height)
      }
    }

    object DroidFriend : ResponseAdapter<HeroDetailsImpl.Friend.DroidFriend> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null),
        ResponseField.forString("primaryFunction", "primaryFunction", null, true, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Friend.DroidFriend {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var primaryFunction: String? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> primaryFunction = readString(RESPONSE_FIELDS[2])
              else -> break
            }
          }
          HeroDetailsImpl.Friend.DroidFriend(
            __typename = __typename!!,
            name = name!!,
            primaryFunction = primaryFunction
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Friend.DroidFriend) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
      }
    }

    object OtherFriend : ResponseAdapter<HeroDetailsImpl.Friend.OtherFriend> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          HeroDetailsImpl.Friend.OtherFriend {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              else -> break
            }
          }
          HeroDetailsImpl.Friend.OtherFriend(
            __typename = __typename!!,
            name = name!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: HeroDetailsImpl.Friend.OtherFriend) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
      }
    }
  }
}