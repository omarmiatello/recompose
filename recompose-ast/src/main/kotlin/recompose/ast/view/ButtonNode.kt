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

package recompose.ast.view

import recompose.ast.Node
import recompose.ast.attributes.ViewAttributes
import recompose.visitor.Visitor

/**
 * Data class holding values of a parsed `<Button>`.
 *
 * https://developer.android.com/reference/android/widget/Button
 */
data class ButtonNode(
    override val view: ViewAttributes,
    val text: String
) : Node {
    override fun accept(visitor: Visitor) = visitor.visitButton(this)
}
