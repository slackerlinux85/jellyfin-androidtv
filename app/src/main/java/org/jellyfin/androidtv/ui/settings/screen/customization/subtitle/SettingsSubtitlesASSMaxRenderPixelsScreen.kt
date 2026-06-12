package org.jellyfin.androidtv.ui.settings.screen.customization.subtitle

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import org.jellyfin.androidtv.R
import org.jellyfin.androidtv.preference.UserPreferences
import org.jellyfin.androidtv.preference.constant.ASSMaxRenderPixels
import org.jellyfin.androidtv.ui.base.Text
import org.jellyfin.androidtv.ui.base.form.RadioButton
import org.jellyfin.androidtv.ui.base.list.ListButton
import org.jellyfin.androidtv.ui.base.list.ListSection
import org.jellyfin.androidtv.ui.navigation.LocalRouter
import org.jellyfin.androidtv.ui.settings.compat.rememberPreference
import org.jellyfin.androidtv.ui.settings.composable.SettingsColumn
import org.koin.compose.koinInject

@Composable
fun SettingsSubtitlesASSMaxRenderPixelsScreen() {
	val router = LocalRouter.current
	val userPreferences = koinInject<UserPreferences>()

	var assMaxRenderPixels by rememberPreference(userPreferences, UserPreferences.assMaxRenderPixels)
	val manualOptions = ASSMaxRenderPixels.entries.filter { it != ASSMaxRenderPixels.AUTO }

	SettingsColumn {
		item {
			ListSection(
				overlineContent = { Text(stringResource(R.string.preference_ass_maxrenderpixels).uppercase()) },
				headingContent = { Text(stringResource(R.string.preference_ass_maxrenderpixels_description)) },
			)
		}

		item {
			ListButton(
				headingContent = { Text(stringResource(ASSMaxRenderPixels.AUTO.nameRes)) },
				trailingContent = { RadioButton(checked = assMaxRenderPixels == ASSMaxRenderPixels.AUTO) },
				onClick = {
					assMaxRenderPixels = ASSMaxRenderPixels.AUTO
					router.back()
				}
			)
		}

		item { ListSection(headingContent = { Text(stringResource(R.string.codec_level_manual)) }) }

		items(manualOptions) { item ->
			ListButton(
				headingContent = { Text(stringResource(item.nameRes)) },
				trailingContent = { RadioButton(checked = assMaxRenderPixels == item) },
				onClick = {
					assMaxRenderPixels = item
					router.back()
				}
			)
		}
	}
}
