package org.jellyfin.androidtv.ui.settings.screen.customization.subtitle

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import org.jellyfin.androidtv.R
import org.jellyfin.androidtv.preference.UserPreferences
import org.jellyfin.androidtv.preference.constant.ASSRenderer
import org.jellyfin.androidtv.ui.base.Text
import org.jellyfin.androidtv.ui.base.form.RadioButton
import org.jellyfin.androidtv.ui.base.list.ListButton
import org.jellyfin.androidtv.ui.base.list.ListSection
import org.jellyfin.androidtv.ui.navigation.LocalRouter
import org.jellyfin.androidtv.ui.settings.compat.rememberPreference
import org.jellyfin.androidtv.ui.settings.composable.SettingsColumn
import org.koin.compose.koinInject

@Composable
fun SettingsSubtitlesASSRendererScreen() {
	val router = LocalRouter.current
	val userPreferences = koinInject<UserPreferences>()

	var assRendererType by rememberPreference(userPreferences, UserPreferences.assRendererType)

	SettingsColumn {
		item {
			ListSection(
				overlineContent = { Text(stringResource(R.string.preference_ass_renderer).uppercase()) },
				headingContent = { Text(stringResource(R.string.preference_ass_renderer_description)) },
			)
		}
		items(ASSRenderer.entries) { item ->
			ListButton(
				headingContent = { Text(stringResource(item.nameRes)) },
				trailingContent = { RadioButton(checked = assRendererType == item) },
				onClick = {
					assRendererType = item
					router.back()
				}
			)
		}
	}
}
