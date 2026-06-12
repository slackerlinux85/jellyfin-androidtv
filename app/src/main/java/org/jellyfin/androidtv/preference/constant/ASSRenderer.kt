package org.jellyfin.androidtv.preference.constant

import org.jellyfin.androidtv.R
import org.jellyfin.preference.PreferenceEnum
import io.github.peerless2012.ass.media.type.AssRenderType

/**
 * renderers to use with LibASS.
 * Values correspond to MediaCodecInfo.CodecProfileLevel constants.
 */
enum class ASSRenderer(
	override val nameRes: Int,
	val value: AssRenderType?,
) : PreferenceEnum {
	OVERLAY_CANVAS(R.string.ass_renderer_overlay_canvas, AssRenderType.OVERLAY_CANVAS),
	OVERLAY_OPEN_GL(R.string.ass_renderer_overlay_open_gl, AssRenderType.OVERLAY_OPEN_GL),
}
