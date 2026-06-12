package org.jellyfin.androidtv.preference.constant

import org.jellyfin.androidtv.R
import org.jellyfin.preference.PreferenceEnum

enum class ASSMaxRenderPixels(
	override val nameRes: Int,
	val value: Int? = 0,
) : PreferenceEnum {
	AUTO(R.string.ass_maxrenderpixels_auto,0),

	@Suppress("MagicNumber")
	HIGH(R.string.ass_maxrenderpixels_high,3686400),
	@Suppress("MagicNumber")
	STANDARD(R.string.ass_maxrenderpixels_standard,2073600),
	@Suppress("MagicNumber")
	LOW(R.string.ass_maxrenderpixels_low,921600),

}
