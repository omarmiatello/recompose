/*
 * Copyright 2020 Sebastian Kaspari
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package recompose.parser.values

import org.xmlpull.v1.XmlPullParser
import recompose.ast.values.LayoutSize
import recompose.parser.Parser

/**
 * Parses a size attribute (from `android:layout_width` or `android:layout_height`and returns the matching [LayoutSize]
 * object. Throws [Parser.ParserException] if the size could not be parsed.
 */
internal fun XmlPullParser.layoutSize(name: String): LayoutSize? {
    val value = getAttributeValue(null, name)
    return when {
        value == null -> null
        value == "match_parent" -> LayoutSize.MatchParent
        value == "wrap_content" -> LayoutSize.WrapContent
        else -> size(name)?.let { LayoutSize.Absolute(it) }
    }
}
