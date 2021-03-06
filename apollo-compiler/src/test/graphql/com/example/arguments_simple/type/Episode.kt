// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.arguments_simple.type

import com.apollographql.apollo.api.EnumValue
import kotlin.Deprecated
import kotlin.String

/**
 * The episodes in the Star Wars trilogy
 */
sealed class Episode(
  override val rawValue: String
) : EnumValue {
  /**
   * Star Wars Episode IV: A New Hope, released in 1977.
   */
  object NEWHOPE : Episode(rawValue = "NEWHOPE")

  /**
   * Star Wars Episode V: The Empire Strikes Back, released in 1980.
   */
  object EMPIRE : Episode(rawValue = "EMPIRE")

  /**
   * Star Wars Episode VI: Return of the Jedi, released in 1983.
   */
  object JEDI : Episode(rawValue = "JEDI")

  /**
   * Test deprecated enum value
   */
  @Deprecated(message = "For test purpose only")
  object DEPRECATED : Episode(rawValue = "DEPRECATED")

  /**
   * Test java reserved word
   */
  @Deprecated(message = "For test purpose only")
  object NEW : Episode(rawValue = "new")

  /**
   * Auto generated constant for unknown enum values
   */
  class UNKNOWN__(
    rawValue: String
  ) : Episode(rawValue = rawValue)

  companion object {
    fun safeValueOf(rawValue: String): Episode = when(rawValue) {
      "NEWHOPE" -> NEWHOPE
      "EMPIRE" -> EMPIRE
      "JEDI" -> JEDI
      "DEPRECATED" -> DEPRECATED
      "new" -> NEW
      else -> UNKNOWN__(rawValue)
    }
  }
}
