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

package dev.dediamondpro.resourcify.util

import dev.dediamondpro.resourcify.platform.Platform
import java.io.File

object ResourcePackUtils {

    fun getPackHashes(): List<String> {
        return getPackFiles().mapNotNull { Utils.getSha1(it) }
    }

    fun getPackFiles(directory: File = Platform.getResourcePackDirectory()): List<File> {
        val files = directory.listFiles() ?: return emptyList()
        val packs = files.filter { it.isFile && it.extension == "zip"  }.toMutableList()
        files.filter { it.isDirectory }.forEach { packs.addAll(getPackFiles(it)) }
        return packs
    }
}