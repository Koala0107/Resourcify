/*
 * This file is part of Resourcify
 * Copyright (C) 2023 DeDiamondPro
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License Version 3
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package dev.dediamondpro.resourcify.gui.resourcepack

import dev.dediamondpro.resourcify.elements.Icon
import dev.dediamondpro.resourcify.elements.MinecraftButton
import dev.dediamondpro.resourcify.gui.browsepage.BrowseScreen
import dev.dediamondpro.resourcify.util.Icons
import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.components.Window
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.dsl.childOf
import gg.essential.elementa.dsl.constrain
import gg.essential.elementa.dsl.pixels
import gg.essential.elementa.dsl.plus
import gg.essential.universal.UMatrixStack
import gg.essential.universal.UScreen

object ResourcePackAddition {
    private val window = Window(ElementaVersion.V2)

    init {
        val button = MinecraftButton().constrain {
            x = CenterConstraint() + 194.pixels()
            y = 10.pixels()
            width = 20.pixels()
            height = 20.pixels()
        }.onMouseClick {
            if (it.mouseButton != 0) return@onMouseClick
            UScreen.displayScreen(BrowseScreen())
        } childOf window
        Icon(Icons.PLUS, true).constrain {
            x = CenterConstraint()
            y = CenterConstraint()
            width = 16.pixels()
            height = 16.pixels()
        } childOf button
    }

    fun onRender(matrix: UMatrixStack) {
        window.draw(matrix)
    }

    fun onMouseClick(mouseX: Double, mouseY: Double, button: Int) {
        window.mouseClick(mouseX, mouseY, button)
    }
}