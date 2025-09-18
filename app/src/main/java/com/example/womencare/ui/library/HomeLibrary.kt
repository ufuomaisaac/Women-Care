package com.example.womencare.ui.library

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.womencare.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.womencare.ui.auth.signin.viewmodel.LanguageViewModel
@Composable
fun CounselingFlowScreen(
    languageViewModel: LanguageViewModel
) {
    val isYoruba by languageViewModel.isYoruba.collectAsState()
    var age by remember { mutableStateOf("") }
    var screenedRecently by remember { mutableStateOf<Boolean?>(null) }
    var knowsHPV by remember { mutableStateOf<Boolean?>(null) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // #1 Welcome
        SectionHeader(if (isYoruba) "Ẹ kú ìbàlẹ̀, obìnrin alágbára!" else "Welcome, dear woman of strength!")
        Paragraph(
            if (isYoruba)
                """
                Ìlera rẹ̀ ni ọrọ̀ rẹ. A wà lẹ́gbẹ̀ẹ́ rẹ.
                Ṣé o mọ̀ pé àrùn ìgbẹ́yà jẹ́ ọ̀kan lára àwọn àrùn tí a lè dáwọ̀ dúró?
                Ìdánwò kíákíá lè mú kó rọrùn láti rí ayipada ṣáájú kí o tó burú.
                Kò pé, kò nira, ó sì lè gba ìyànjú.
                """.trimIndent()
            else
                """
                Your health is your wealth, and we're here with you.
                Do you know that cervical cancer is one of the few cancers that can be prevented?
                Quick screening helps find early changes before they become serious.
                It’s fast, safe, and can save your life.
                """.trimIndent()
        )

        // #2 Screening Info
        SectionHeader(if (isYoruba) "Ìmọ̀ nípa Ìdánwò Ìgbẹ́yà" else "Understanding the Screening Process")
        Paragraph(
            if (isYoruba)
                """
                Ọ̀pọ̀ obìnrin ní ìbànújẹ̀ tàbí ìkà. Ìwọ kì í ṣe rẹ́mú kàn!
                ✔️ Ó gba iṣẹ́jú 10–15.
                ✔️ Kò ṣẹ́lẹ̀ fún ìbálòpọ̀ tàbí ìyà ọmọ.
                ✔️ Kò kó ìrẹsì kúrò.
                ✔️ Ó lè rí àsọtẹ́lẹ̀ ṣáájú kí àámì hàn.
                Ronu rẹ̀ gẹ́gẹ́ bí ìyẹ̀wò ọkọ ayọ́kẹ́lẹ́—rírí àṣìṣe ṣáájú dandan.
                """.trimIndent()
            else
                """
                Many women feel frightened or unsure about screening. You are not alone!
                ✔️ It takes just 10–15 minutes.
                ✔️ Usually painless or mildly uncomfortable.
                ✔️ Does not affect virginity or fertility.
                ✔️ It detects early signs before symptoms appear.
                Think of it like a car check‑up — best caught early.
                """.trimIndent()
        )

        // #3 Myths & Truths inside Card
        SectionHeader(if (isYoruba) "Ṣíṣe kúrò nínú awọn èrò àìtó" else "Myths & Truths")
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                MythAndTruth(
                    myth = if (isYoruba) "❌ “Mi ò ní ààmì, bẹ́ẹ̀ni mo wà láradá.”"
                    else "❌ “I don’t have symptoms, so I’m fine.”",
                    truth = if (isYoruba) "✅ Àrùn ìgbẹ́yà sábà ń hàn dákẹ́; ìdánwò kókó ni."
                    else "✅ Truth: Cervical cancer shows no early signs. Early screening is essential."
                )
                MythAndTruth(
                    myth = if (isYoruba) "❌ “Ó jẹ́ ẹ̀tàn tàbí kó bà mí lórí.”"
                    else "❌ “It’s shameful or painful.”",
                    truth = if (isYoruba) "✅ Ó ń ṣiṣẹ́ láti ọwọ́ oníwòsàn obìnrin, ó sì kéré ju iṣẹ́ju kan."
                    else "✅ It’s done respectfully by trained female staff and is quick."
                )
                MythAndTruth(
                    myth = if (isYoruba) "❌ “Mo bẹ̀rù abajade rẹ̀.”"
                    else "❌ “I’m afraid of the results.”",
                    truth = if (isYoruba) "✅ Ìfihàn kókó ń jẹ́ kí o ní àmúró ìtọ́jú."
                    else "✅ Early detection gives you timely treatment and peace of mind."
                )
            }
        }

        // #4 Call to Action
        SectionHeader(if (isYoruba) "Ìpè àtìmọ̀ràn" else "Call to Action")
        Paragraph(
            if (isYoruba)
                """
                O ti dé ibi ti o yẹ̀ — ó túmọ̀ sí pé ìwọ bára rẹ̀ nínú.
                Ìwọ ni ìyá, arábìnrin, aya, olórí — ìlera rẹ̀ jẹ́ bí ìbelẹ̀ fún ẹbí rẹ.
                Má ṣiyèméjì! Jẹ́ ká forúkọsílẹ̀ fún ìdánwò rẹ̀ lónìí.
                MomaCare wà pẹ̀lú rẹ — ìdánwò kékeré, àlàáfíà tó pé.
                """.trimIndent()
            else
                """
                You’ve come this far—that means you care.
                You’re a mother, sister, wife, leader—your health matters to your family.
                Don’t wait—let’s book your screening today.
                MomaCare is with you—even a small test can bring peace of mind.
                """.trimIndent()
        )

        // #5 Form Inputs
        SectionHeader(if (isYoruba) "Ìdánwò Ìlera Ìgbẹ́yà" else "Health Check")
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text(if (isYoruba) "Ọjọ́‑ori rẹ?" else "What is your age?") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Column { Text(if (isYoruba) "Ṣé o ti ṣe ìdánwò ṣáájú?" else "Had a previous screening?") }
            RadioButtonWithLabel(if (isYoruba) "Bẹ́ẹ̀ni" else "Yes", screenedRecently == true) { screenedRecently = true }
            RadioButtonWithLabel(if (isYoruba) "Rárá" else "No", screenedRecently == false) { screenedRecently = false }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Column { Text(if (isYoruba) "Ṣé o mọ̀ pé kí ni HPV?" else "Do you know what HPV is?") }
            RadioButtonWithLabel(if (isYoruba) "Bẹ́ẹ̀ni" else "Yes", knowsHPV == true) { knowsHPV = true }
            RadioButtonWithLabel(if (isYoruba) "Rárá" else "No", knowsHPV == false) { knowsHPV = false }
        }

        // #6 Recommendation Button
        Button(
            onClick = {
                val ageNum = age.toIntOrNull() ?: return@Button
                result = generateRecommendation(ageNum, screenedRecently, knowsHPV, isYoruba)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isYoruba) "Gba ìmọ̀ràn" else "Get Recommendation")
        }

        result.takeIf { it.isNotBlank() }?.let {
            Text(it, style = MaterialTheme.typography.bodyLarge)
        }

        if (knowsHPV == false) {
            HPVKnowledgeSection(isYoruba)
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}


@Composable
fun SectionHeader(text: String) {
    Text(text, style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.primary)
}

@Composable
fun Paragraph(text: String) {
    Text(text, style = MaterialTheme.typography.bodyLarge, lineHeight = 24.sp)
}

@Composable
fun MythAndTruth(myth: String, truth: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(myth, color = Color.Red, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(4.dp))
        Text(truth, color = Color(0xFF2E7D32), style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun RadioButtonWithLabel(label: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        Modifier
            .padding(end = 16.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = null)
        Text(label)
    }
}



@Composable
fun HPVKnowledgeSection(isYoruba: Boolean) {
    Column {
        SectionTitle(if (isYoruba) "🧬 Kí ni HPV?" else "🧬 What is HPV?")
        BulletPoints(
            if (isYoruba)
                listOf(
                    "HPV (Human Papillomavirus) jẹ́ àrùn tí ó wọ́pọ̀ gan-an.",
                    "Ó ń tan nípasẹ̀ ìfarahan awọ sí awọ, bó ti wù kí ó jẹ́ ìbálòpọ̀.",
                    "Ọ̀pọ̀ ènìyàn ni ń ní í lẹ́ẹ̀kan; ó máa ń lọ nítorí ara."
                )
            else
                listOf(
                    "HPV (Human Papillomavirus) is very common.",
                    "Spreads through skin-to-skin contact, often during sex.",
                    "Most people get it at some point—usually clears on its own."
                )
        )

        SectionTitle(if (isYoruba) "❗ Kí ló ṣe pàtàkì nípa HPV?" else "❗ Why is HPV important?")
        BulletPoints(
            if (isYoruba)
                listOf(
                    "Diẹ̀ lára rẹ̀ le fa àrùn ìgbẹ́yà.",
                    "HPV onírúurú 16 àti 18 ni wọ́n jẹ́ kókó nínú ọ̀pọ̀ àrùn.",
                    "Ó tún ní ìbáṣepọ̀ pẹ̀lú àwọn àrùn àkúnya míì àti wàárìtì."
                )
            else
                listOf(
                    "Some types can cause cervical cancer.",
                    "High-risk types (16 and 18) cause most cases.",
                    "Also linked to other cancers and genital warts."
                )
        )

        SectionTitle(if (isYoruba) "🎯 Àwọn nǹkan tó le pọ̀ si ewu àrùn ìgbẹ́yà" else "🎯 Risk Factors for Cervical Cancer")
        BulletPoints(
            if (isYoruba)
                listOf(
                    "Ìbálòpọ̀ pẹ̀lú ọ̀pọ̀ alábàápàdé.",
                    "Bibẹrẹ ìbálòpọ̀ ní kékeré.",
                    "Ìtọ́jú àìlera (bí HIV).",
                    "Mímu tàbí sísun.",
                    "Kíkù àyẹ̀wò ìlera déédé.",
                    "Àì gba abẹ̀rẹ̀ HPV."
                )
            else
                listOf(
                    "Multiple sexual partners.",
                    "Early sexual activity.",
                    "Weakened immune system (e.g., HIV).",
                    "Smoking.",
                    "Skipping regular screenings.",
                    "Not getting the HPV vaccine."
                )
        )

        SectionTitle(if (isYoruba) "💉 Abẹ̀rẹ̀ HPV" else "💉 HPV Vaccine")
        BulletPoints(
            if (isYoruba)
                listOf(
                    "Ó dáàbò bo oríṣìíríṣìí HPV tí ó lewu jùlọ.",
                    "Ó dájú láti gba ṣáájú ìbálòpọ̀, ṣùgbọ́n àgbàlagbà tún le rí àǹfààní.",
                    "Ó dájú àti pé ó munadoko."
                )
            else
                listOf(
                    "Protects against the most dangerous HPV types.",
                    "Best before sexual activity, but adults can benefit too.",
                    "Safe and effective."
                )
        )
    }
}


fun generateRecommendation(
    age: Int?,
    screenedRecently: Boolean?,
    knowsHPV: Boolean?,
    isYoruba: Boolean
): String {
    if (age == null) return ""

    val mainMessage = when {
        age < 25 -> if (isYoruba)
            "O wa ní kéré ju ọjọ́-ori àyẹ̀wò lọ. Ṣùgbọ́n ìmọ̀ rẹ jẹ́ agbára. Mà ṣe dáwọ̀ kọ́!"
        else
            "You’re currently below the recommended screening age, but your awareness is powerful. Stay informed!"

        age in 25..49 && screenedRecently == false -> if (isYoruba)
            "Ó tọ́ ọ́ kí o ṣe àyẹ̀wò ìgbẹ́yà. Ẹ jẹ́ ká ṣe ìpinnu pẹ̀lú rẹ báyìí."
        else
            "You're due for a cervical screening. Let's help you schedule one."

        age in 25..49 && screenedRecently == true -> if (isYoruba)
            "Ó dára pé o ti ṣe àyẹ̀wò laipẹ—ẹ̀ ṣeun! Màa bá a lọ ní títẹ̀síwájú."
        else
            "You've had a screening recently—great job! Keep it up and stay informed."

        age in 50..64 && screenedRecently == false -> if (isYoruba)
            "Òun ni àkókò tó yẹ kó o bẹ̀rẹ̀ àyẹ̀wò. A wà pẹ̀lú rẹ láti fi ràn é lọ́wọ́."
        else
            "It's time to start cervical screening. We'll guide you through the next steps."

        age in 50..64 && screenedRecently == true -> if (isYoruba)
            "O ń ṣe iṣẹ́ rere nínú títọ́jú ara rẹ. Ẹ̀ ku iṣẹ́!"
        else
            "You're doing a wonderful job taking care of your health!"

        age >= 65 && screenedRecently == true -> if (isYoruba)
            "Káàbọ̀! O ń gbìyànjú láti tọ́jú ilera rẹ. Ẹ̀ kú iṣẹ́."
        else
            "Fantastic! You're staying proactive about your health."

        age >= 65 && screenedRecently == false -> if (isYoruba)
            "Jọ̀ọ́ bá onímọ̀ ìlera sọ̀rọ̀ nípa bóyá ìdánwò ṣi yẹ fún ọ."
        else
            "Please speak with a healthcare provider about whether you still need screening."

        else -> if (isYoruba)
            "Ẹ ṣé gan-an fún àbẹ̀wò yìí. O ti gbé ìgbésẹ̀ rere fún ilera rẹ."
        else
            "Thank you for being here. You're taking a great step for your health."
    }

    val hpvMessage = if (knowsHPV == false) {
        if (isYoruba)
            "\n\n🔍 Bẹ́ẹ̀ ni, HPV (Human Papillomavirus) ni ìdí pàtàkì jùlọ tí ó ń fa àrùn ìgbẹ́yà. Ọ̀pọ̀ ènìyàn ló ní í láì mọ̀. Ìmọ̀ yìí lè dáàbò bo ilera rẹ."
        else
            "\n\n🔍 By the way, HPV (Human Papillomavirus) is the main cause of cervical cancer. Most people get it without knowing. Learning more can help protect your health!"
    } else ""

    return mainMessage + hpvMessage
}


@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewCounselingFlowScreen() {
    MaterialTheme {
       // CounselingFlowScreen()
    }
}


@Composable
fun CervicalCancerInfoScreen(
    navController: NavController,
    languageViewModel: LanguageViewModel
) {
    val isYoruba by languageViewModel.isYoruba.collectAsState()
    val scrollState = rememberScrollState()

    val context = LocalContext.current
    val uri1 = Uri.parse("android.resource://${context.packageName}/${R.raw.eliminating_cervical_cancer}")
    val uri2 = Uri.parse("android.resource://${context.packageName}/${R.raw.video1}")

    val articles = listOf(
        ArticleData("🚨 Early Signs & Screening:", "What Every Woman Should Know", R.drawable.ab3_stretching, "23/12/2021"),
        ArticleData("Burden & Prevention", "Global Overview of Cervical Cancer", R.drawable.ab6_pre_natal_yoga, "23/12/2021"),
    )

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Language toggle
       Spacer(Modifier.height(16.dp))


        androidx.compose.material3.Text(
            text = if (isYoruba) "Àrùn OGVÌ" else "Cervical Cancer",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        androidx.compose.material3.Text(
            text = if (isYoruba)
                "Àrùn OGVÌ jẹ́ àrùn kan tó bẹ̀rẹ̀ ní sẹ́lù OGVÌ. Ó lè dènà àti tọ́jú ní kíákíá."
            else
                "Cervical cancer is a type of cancer that starts in the cells of the cervix…",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Section(if (isYoruba) "🧬 Ìdí" else "🧬 Cause") {
            androidx.compose.material3.Text(
                text = if (isYoruba)
                    "Awọn ọlọjẹ HPV tó lewu, pàápàá 16 àti 18, ni ń fa àrùn yii."
                else
                    "The primary cause is persistent infection with high‑risk types of HPV, especially types 16 and 18.",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Section(if (isYoruba) "🔍 Bí ó ti ń dagbasoke" else "🔍 Development") {
            androidx.compose.material3.Text(
                text = if (isYoruba)
                    "Ó sábà ń dagbasoke díẹ̀ díẹ̀: sẹ́lù deede → CIN → àrùn tó jinlẹ."
                else
                    "Cervical cancer usually develops slowly over time: Normal cervical cells → Precancerous changes (CIN) → Invasive cancer.",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Section(if (isYoruba) "⚠️ Ààmì" else "⚠️ Symptoms") {
            BulletPoints(
                items = if (isYoruba) listOf(
                    "Ẹjẹ̀ àìlódí (lẹ́yìn ibalopo, láàárin oṣù, lẹhin ìmúlẹ̀)",
                    "Ìtúpalẹ̀ obìnrin tó yàtọ̀",
                    "Ìrora ní pelvic tàbí nígbà ìbálòpọ̀"
                ) else listOf(
                    "Abnormal vaginal bleeding (e.g., after sex…)",
                    "Unusual vaginal discharge",
                    "Pelvic pain or pain during intercourse"
                )
            )
        }

        Section(if (isYoruba) "🛡️ Ìdènà" else "🛡️ Prevention") {
            BulletPoints(
                items = if (isYoruba) listOf(
                    "Abẹrẹ HPV ṣáájú ìbálòpọ̀",
                    "Pap smear ati ìwádìí HPV gbogbo",
                    "Ìbálòpọ̀ àabo (kondomu)"
                ) else listOf(
                    "HPV vaccination (before sexual activity begins)",
                    "Regular Pap smears and HPV testing",
                    "Safe sex practices (e.g., condom use)"
                )
            )
        }

        Section(if (isYoruba) "🩺 Ìtọ́jú" else "🩺 Treatment") {
            BulletPoints(
                items = if (isYoruba) listOf(
                    "Ìoperẹ (bí hysterectomy)",
                    "Radiation therapy",
                    "Kemoterapi",
                    "Immunotherapy"
                ) else listOf(
                    "Surgery (e.g., hysterectomy)",
                    "Radiation therapy",
                    "Chemotherapy",
                    "Targeted therapy or immunotherapy"
                )
            )
        }

        SectionTitle(if (isYoruba) "🛡️ Ọjọ́ ìwádì" else "🛡️ Screening Frequency")
        BulletPoints(
            items = if (isYoruba) listOf(
                "Ọdún 25–49: lẹ́ẹ̀kan ní ọdún mẹ́ta.",
                "Ọdún 50–64: lẹ́ẹ̀kan ní ọdún márún-ún.",
                "Ní Naijiria: lẹ́ẹ̀kan lododun."
            ) else listOf(
                "Ages 25–49: every 3 years.",
                "Ages 50–64: every 5 years if previous results were normal.",
                "In Nigeria: once a year is often recommended."
            )
        )

        SectionTitle(if (isYoruba) "🗺️ Níbí ti o ti lè lọ ní Osun" else "🗺️ Where to Screen in Osun State")
        BulletPoints(
            items =  listOf(
                "OAUTHC, Ile-Ife",
                "UNIOSUN Teaching Hospital, Osogbo",
                "State Specialist Hospital, Osogbo",
                "Fountain University Health Centre",
                "Iremide Medical Centre Annex",
                "FOMWAN Secretariat, Ogo‑Oluwa"
            )
        )

        Spacer(Modifier.height(16.dp))
        Text(if (isYoruba) "Àwọn Ìtàn Ìlera" else "Health Tips Articles", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))
        articles.forEach { art ->
            ArticleCard(article = art, onItemClicked = { navController.navigate(Articles.FirstArticle.name) })
            Spacer(Modifier.height(8.dp))
        }

        Spacer(Modifier.height(16.dp))
        Text(if (isYoruba) "Fídíò Ìlera" else "Health Tips Video", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        VideoPlayer(context, uri1)
        Spacer(Modifier.height(8.dp))
        VideoPlayer(context, uri2)
    }
}


@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    androidx.compose.material3.Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
    content()
}

@Composable
fun BulletPoints(items: List<String>) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        items.forEach { item ->
            androidx.compose.material3.Text(
                text = "• $item",
                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
            )
        }
    }
}

@Composable
fun TwoImagesTopBottom() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Top Image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.image2),
            contentDescription = "Bottom Image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
    }
}




