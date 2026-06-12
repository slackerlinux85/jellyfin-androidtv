package org.jellyfin.androidtv.ui.settings.screen.customization.subtitle

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.jellyfin.androidtv.R
import org.jellyfin.androidtv.preference.UserPreferences
import org.jellyfin.androidtv.ui.base.Text
import org.jellyfin.androidtv.ui.base.form.RangeControl
import org.jellyfin.androidtv.ui.base.list.ListButton
import org.jellyfin.androidtv.ui.base.list.ListControl
import org.jellyfin.androidtv.ui.base.list.ListSection
import org.jellyfin.androidtv.ui.navigation.LocalRouter
import org.jellyfin.androidtv.ui.settings.Routes
import org.jellyfin.androidtv.ui.settings.compat.rememberPreference
import org.jellyfin.androidtv.ui.settings.composable.SettingsColumn
import org.jellyfin.design.Tokens
import org.koin.compose.koinInject

@Composable
fun SettingsSubtitlesAssOptionsScreen() {
	val router = LocalRouter.current
	val userPreferences = koinInject<UserPreferences>()

	SettingsColumn {
		item {
			ListSection(
				overlineContent = { Text(stringResource(R.string.pref_customization).uppercase()) },
				headingContent = { Text(stringResource(R.string.pref_customization_subtitles_libassoptions)) },
			)
		}

		// libASS Options
		item {
			// libASS Renderer
			var assRendererType by rememberPreference(userPreferences, UserPreferences.assRendererType)
			ListButton(
				headingContent = { Text(stringResource(R.string.preference_ass_renderer)) },
				captionContent = { Text(stringResource(assRendererType.nameRes)) },
				onClick = { router.push(Routes.CUSTOMIZATION_SUBTITLES_ASS_RENDERER) }
			)
		}

		item {
			// libASS glyphSize
			val interactionSource = remember { MutableInteractionSource() }
			var assGlyphSize by rememberPreference(userPreferences, UserPreferences.assGlyphSize)

			ListControl(
				headingContent = { Text(stringResource(R.string.preference_ass_glyphsize)) },
				captionContent = { Text(stringResource(R.string.preference_ass_glyphsize_description)) },
				interactionSource = interactionSource,
			) {
				Row(
					verticalAlignment = Alignment.CenterVertically,
				) {
					RangeControl(
						modifier = Modifier
							.height(4.dp)
							.weight(1f),
						interactionSource = interactionSource,
						min = 8000f,
						max = 20000f,
						stepForward = 100f,
						value = assGlyphSize.toFloat(),
						onValueChange = { assGlyphSize = it.toInt() }
					)

					Spacer(Modifier.width(Tokens.Space.spaceSm))

					Box(
						modifier = Modifier.sizeIn(minWidth = 32.dp),
						contentAlignment = Alignment.CenterEnd
					) {
						Text(assGlyphSize.toString())
					}
				}
			}
		}

		item {
			// libASS CacheSize
			val interactionSource = remember { MutableInteractionSource() }
			var assCacheSize by rememberPreference(userPreferences, UserPreferences.assCacheSize)

			ListControl(
				headingContent = { Text(stringResource(R.string.preference_ass_cachesize)) },
				captionContent = { Text(stringResource(R.string.preference_ass_cachesize_description)) },
				interactionSource = interactionSource,
			) {
				Row(
					verticalAlignment = Alignment.CenterVertically,
				) {
					RangeControl(
						modifier = Modifier
							.height(4.dp)
							.weight(1f),
						interactionSource = interactionSource,
						min = 64f,
						max = 256f,
						stepForward = 8f,
						value = assCacheSize.toFloat(),
						onValueChange = { assCacheSize = it.toInt() }
					)

					Spacer(Modifier.width(Tokens.Space.spaceSm))

					Box(
						modifier = Modifier.sizeIn(minWidth = 32.dp),
						contentAlignment = Alignment.CenterEnd
					) {
						Text(assCacheSize.toString() + "MB")
					}
				}
			}
		}

		item {
			// libASS MaxRenderPixels
			var assMaxRenderPixels by rememberPreference(userPreferences, UserPreferences.assMaxRenderPixels)
			ListButton(
				headingContent = { Text(stringResource(R.string.preference_ass_maxrenderpixels)) },
				captionContent = { Text(stringResource(assMaxRenderPixels.nameRes)) },
				onClick = { router.push(Routes.CUSTOMIZATION_SUBTITLES_ASS_MAX_RENDER_PIXELS) }
			)
		}
	}
}
