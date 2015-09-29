package com.github.vmironov.github.jetpack.arguments

import android.app.Fragment
import android.os.Bundle
import android.test.AndroidTestCase
import com.github.vmironov.jetpack.arguments.*
import junit.framework.Assert

public class ArgumentBindingsTest : AndroidTestCase() {
  public fun testExplicitRequiredBindings() {
    class ArgumentsFragment : Fragment() {
      val integer by bindIntArgument("integer")
      val boolean by bindBooleanArgument("boolean")
      val string by bindStringArgument("string")
      val long by bindLongArgument("long")
      val double by bindDoubleArgument("double")
      val float by bindFloatArgument("float")
    }

    val fragment = ArgumentsFragment().apply {
      arguments = Bundle().apply {
        putInt("integer", 12)
        putBoolean("boolean", true)
        putString("string", "rainbow dash")
        putLong("long", 37L)
        putDouble("double", 1.25)
        putFloat("float", 2.5f)
      }
    }

    Assert.assertEquals(12, fragment.integer)
    Assert.assertEquals(true, fragment.boolean)
    Assert.assertEquals("rainbow dash", fragment.string)
    Assert.assertEquals(37L, fragment.long)
    Assert.assertEquals(1.25, fragment.double)
    Assert.assertEquals(2.5f, fragment.float)
  }

  public fun testImplicitRequiredBindings() {
    class ArgumentsFragment : Fragment() {
      val integer by bindIntArgument()
      val boolean by bindBooleanArgument()
      val string by bindStringArgument()
      val long by bindLongArgument()
      val double by bindDoubleArgument()
      val float by bindFloatArgument()
    }

    val fragment = ArgumentsFragment().apply {
      arguments = Bundle().apply {
        putInt("integer", 33)
        putBoolean("boolean", false)
        putString("string", "pinkie pie")
        putLong("long", 14L)
        putDouble("double", 3.14)
        putFloat("float", 2.71f)
      }
    }

    Assert.assertEquals(33, fragment.integer)
    Assert.assertEquals(false, fragment.boolean)
    Assert.assertEquals("pinkie pie", fragment.string)
    Assert.assertEquals(14L, fragment.long)
    Assert.assertEquals(3.14, fragment.double)
    Assert.assertEquals(2.71f, fragment.float)
  }

  public fun testRequiredBindingsWithDefaultsWhenArgumentsMissedWithoutBundle() {
    class ArgumentsFragment : Fragment() {
      val integer by bindIntArgument("integer", 4)
      val boolean by bindBooleanArgument("boolean", true)
      val string by bindStringArgument("string", "flutter shy")
      val long by bindLongArgument("long", 7L)
      val double by bindDoubleArgument("double", 1.23)
      val float by bindFloatArgument("float", 4.56f)
    }

    val fragment = ArgumentsFragment().apply {
      arguments = null
    }

    Assert.assertEquals(4, fragment.integer)
    Assert.assertEquals(true, fragment.boolean)
    Assert.assertEquals("flutter shy", fragment.string)
    Assert.assertEquals(7L, fragment.long)
    Assert.assertEquals(1.23, fragment.double)
    Assert.assertEquals(4.56f, fragment.float)
  }

  public fun testRequiredBindingsWithDefaultsWhenArgumentsMissedWithEmptyBundle() {
    class ArgumentsFragment : Fragment() {
      val integer by bindIntArgument("integer", 4)
      val boolean by bindBooleanArgument("boolean", true)
      val string by bindStringArgument("string", "flutter shy")
      val long by bindLongArgument("long", 7L)
      val double by bindDoubleArgument("double", 1.23)
      val float by bindFloatArgument("float", 4.56f)
    }

    val fragment = ArgumentsFragment().apply {
      arguments = Bundle.EMPTY
    }

    Assert.assertEquals(4, fragment.integer)
    Assert.assertEquals(true, fragment.boolean)
    Assert.assertEquals("flutter shy", fragment.string)
    Assert.assertEquals(7L, fragment.long)
    Assert.assertEquals(1.23, fragment.double)
    Assert.assertEquals(4.56f, fragment.float)
  }

  public fun testRequiredBindingsWithDefaultsWhenArgumentsSet() {
    class ArgumentsFragment : Fragment() {
      val integer by bindIntArgument("integer", 4)
      val boolean by bindBooleanArgument("boolean", true)
      val string by bindStringArgument("string", "flutter shy")
      val long by bindLongArgument("long", 7L)
      val double by bindDoubleArgument("double", 1.23)
      val float by bindFloatArgument("float", 4.56f)
    }

    val fragment = ArgumentsFragment().apply {
      arguments = Bundle().apply {
        putInt("integer", 33)
        putBoolean("boolean", false)
        putString("string", "pinkie pie")
        putLong("long", 14L)
        putDouble("double", 3.14)
        putFloat("float", 2.71f)
      }
    }

    Assert.assertEquals(33, fragment.integer)
    Assert.assertEquals(false, fragment.boolean)
    Assert.assertEquals("pinkie pie", fragment.string)
    Assert.assertEquals(14L, fragment.long)
    Assert.assertEquals(3.14, fragment.double)
    Assert.assertEquals(2.71f, fragment.float)
  }

  public fun testOptionalBindingsWithoutArguments() {
    class ArgumentsFragment : Fragment() {
      val integer by bindOptionalIntArgument("integer")
      val boolean by bindOptionalBooleanArgument("boolean")
      val string by bindOptionalStringArgument("string")
      val long by bindOptionalLongArgument("long")
      val double by bindOptionalDoubleArgument("double")
      val float by bindOptionalFloatArgument("float")
    }

    val fragment = ArgumentsFragment().apply {
      arguments = Bundle()
    }

    Assert.assertEquals(null, fragment.integer)
    Assert.assertEquals(null, fragment.boolean)
    Assert.assertEquals(null, fragment.string)
    Assert.assertEquals(null, fragment.long)
    Assert.assertEquals(null, fragment.double)
    Assert.assertEquals(null, fragment.float)
  }

  public fun testOptionalBindingsWithArguments() {
    class ArgumentsFragment : Fragment() {
      val integer by bindOptionalIntArgument("integer")
      val boolean by bindOptionalBooleanArgument("boolean")
      val string by bindOptionalStringArgument("string")
      val long by bindOptionalLongArgument("long")
      val double by bindOptionalDoubleArgument("double")
      val float by bindOptionalFloatArgument("float")
    }

    val fragment = ArgumentsFragment().apply {
      arguments = Bundle().apply {
        putInt("integer", 33)
        putBoolean("boolean", false)
        putString("string", "pinkie pie")
        putLong("long", 14L)
        putDouble("double", 3.14)
        putFloat("float", 2.71f)
      }
    }

    Assert.assertEquals(33, fragment.integer)
    Assert.assertEquals(false, fragment.boolean)
    Assert.assertEquals("pinkie pie", fragment.string)
    Assert.assertEquals(14L, fragment.long)
    Assert.assertEquals(3.14, fragment.double)
    Assert.assertEquals(2.71f, fragment.float)
  }
}
