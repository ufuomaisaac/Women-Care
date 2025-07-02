package com.example.womencare.ui.library

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.womencare.ui.auth.signin.LanguageViewModel

@Composable
fun CounselingFlowScreen(
    languageViewModel: LanguageViewModel = hiltViewModel()
) {
    var isYoruba by remember { mutableStateOf(false) }
    var age by remember { mutableStateOf("") }
    var screenedRecently by remember { mutableStateOf<Boolean?>(null) }
    var knowsHPV by remember { mutableStateOf<Boolean?>(null) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Language Toggle
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("English")
            Switch(
                checked = isYoruba,
                onCheckedChange = { isYoruba = it }
            )
            Text("Yorùbá")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 MODULE 1: Welcome
        SectionHeader(if (isYoruba) "Ẹ ku ìbàlẹ̀, obìnrin alágbára!" else "Welcome, dear woman of strength!")
        Paragraph(
            if (isYoruba) """
                Ìlera rẹ̀ ni ọrọ̀ rẹ. A wà lẹ́gbẹ̀ẹ́ rẹ.
                Ṣé o mọ̀ pé àrùn ìgbẹ́yà jẹ́ ọ̀kan lára àwọn àrùn tí a lè dáwọ̀ dúró?
                Ìdánwò kíákíá lè mú kó rọrùn láti rí ayipada ṣáájú kí o tó burú.
                Kò pé, kò nira, ó sì lè gba ìyànjú.
            """.trimIndent()
            else """
                
                Your health is your wealth, and we're here to walk with you.      
                Do you know that cervical cancer is one of the few cancers that can actually be prevented?
                Screening helps us catch early changes before they become dangerous
                It’s quick, safe, and can save your life.
            """.trimIndent()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 MODULE 2: Screening Process
        SectionHeader(if (isYoruba) "Ìmọ̀ nípa Ìdánwò Ìgbẹ́yà" else "Understanding the Screening Process")
        Paragraph(
            if (isYoruba) """
                Ọ̀pọ̀ obìnrin ni ń bẹ̀rù ìdánwò yìí. Ṣùgbọ́n, ìwọ kò wà ní kànkan!
                
                ✔️ Ó gba iṣẹju díẹ̀ péré (10–15).
                ✔️ Kò ní bàjẹ́ fún ìbálòpọ̀ tàbí èròjà obìnrin rẹ.
                ✔️ Kò yọ ìrẹsì nù.
                ✔️ Ó lè rí àfihàn àkókò ṣáájú kí àìlera tó hàn gbangba.
                Bíràkù rẹ̀ mọ́ kó jẹ́ bi ṣíṣe ayẹwo ọkọ ayọ́kẹ́lẹ́ rẹ.
            """.trimIndent()
            else """
                Many women are scared or unsure about cervical screening. You are not alone!
                
                ✔️ Screening takes just 10–15 minutes.
                ✔️ It is usually painless or mildly uncomfortable.
                ✔️ It does not take your virginity or affect fertility.
                ✔️ It can detect early signs long before symptoms appear.
                Think of it like a car check-up — it's better to detect a fault early.
            """.trimIndent()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 MODULE 3: Myths & Barriers
        SectionHeader(if (isYoruba) "Ṣíṣe kúrò nínú àwọn èrò àìtó" else "Overcoming Myths & Barriers")
        MythAndTruth(
            myth = if (isYoruba) "❌ “Mi ò ní ààmì, bẹ́ẹ̀ni mo wà láradá.”"
            else "❌ “I don’t have symptoms, so I’m fine.”",
            truth = if (isYoruba) "✅ Otitọ ni pé àrùn ìgbẹ́yà máa ń dàgbà lọ́nà tí kò fi hàn gbangba. Ìdánwò ní kókó ni."
            else "✅ Truth: Cervical cancer doesn’t show signs until it’s advanced. Early screening is key."
        )
        MythAndTruth(
            myth = if (isYoruba) "❌ “Ó jẹ́ ẹ̀tàn tàbí kó bà mí lórí.”"
            else "❌ “It’s shameful or painful.”",
            truth = if (isYoruba) "✅ Ó ń ṣẹlẹ̀ ní àìmọ̀nà, pẹ̀lú àwọn alágbàse obìnrin. Ó gba iṣẹ́jú díẹ̀ péré."
            else "✅ Truth: It is done respectfully by trained female staff and takes a few minutes."
        )
        MythAndTruth(
            myth = if (isYoruba) "❌ “Mo bẹ̀rù abajade rẹ̀.”"
            else "❌ “I’m afraid of the results.”",
            truth = if (isYoruba) "✅ Ìfihàn àkókò dá òye ẹ̀mí padà — ó lè gba ẹ̀tọ́ ìtọ́jú."
            else "✅ Truth: Early detection gives you a higher chance to be treated and live well."
        )

        Paragraph(
            if (isYoruba) "Rí i dájú pé ìmọ̀ yìí jẹ́ agbára — kì í ṣe ohun ẹ̀rù."
            else "Remember, being informed is not fearful — it’s powerful."
        )
        Spacer(modifier = Modifier.height(16.dp))
        // 🔹 MODULE 4: Motivational Call
        SectionHeader(if (isYoruba) "Ìpè àtìmọ̀ràn pẹ̀lú ìtara" else "Motivational Call to Action")
        Paragraph(
            if (isYoruba) """
                
                Tí o bá ti dé bí bẹ́ẹ̀, ó túmọ̀ sí pé o ṣe pàtàkì.
                Ìwọ jẹ́ ìyá, arábìnrin, aya, olórí — ilera rẹ jẹ́ gbígbà lórí fún ẹbí rẹ.
                Má bà a lọ́! Ẹ jẹ́ ká forúkọsílẹ̀ fún ìdánwò rẹ lónìí.
                MomaCare wà pẹ̀lú rẹ. Ìdánwò kékeré le jẹ́ ìkànsí àlàáfíà àná.
            """.trimIndent()
            else """
                
                You’ve come this far — and that means you care. Now is the time to act.
                You are a mother, a sister, a wife, a leader — and your family needs you healthy.
                Don’t wait until it’s too late.
                Let’s book your screening today. You’re not alone — MomaCare is with you.
                A small test now can give you peace of mind later.
            """.trimIndent()
        )

        // 🔹 FORM: Cervical Health Check
        SectionHeader(if (isYoruba) "Ìdánwò Ìlera Ìgbẹ́yà" else "Cervical Health Check")

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = {
                Text(if (isYoruba) "Ìgbọ̀nwọ̀ ọjọ́ ori rẹ?" else "What is your age?")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(if (isYoruba) "Ṣé o ti ṣe ìdánwò ṣáájú?" else "Have you had a cervical screening before?")
        Row {
            RadioButtonWithLabel(if (isYoruba) "Bẹ́ẹ̀ni" else "Yes", screenedRecently == true) { screenedRecently = true }
            RadioButtonWithLabel(if (isYoruba) "Rárá" else "No", screenedRecently == false) { screenedRecently = false }
        }

        Text(if (isYoruba) "Ṣé o mọ̀ ohun tí HPV jẹ́?" else "Do you know what HPV is?")
        Row {
            RadioButtonWithLabel(if (isYoruba) "Bẹ́ẹ̀ni" else "Yes", knowsHPV == true) { knowsHPV = true }
            RadioButtonWithLabel(if (isYoruba) "Rárá" else "No", knowsHPV == false) { knowsHPV = false }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val ageNum = age.toIntOrNull() ?: return@Button
            result = generateRecommendation(
                ageNum, screenedRecently, knowsHPV,
                isYoruba = isYoruba
            )
        }) {
            Text(if (isYoruba) "Gba ìmọ̀ràn" else "Get Recommendation")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (result.isNotBlank()) {
            Text(result, style = MaterialTheme.typography.bodyLarge)
        }

        if (knowsHPV == false) {
            Spacer(modifier = Modifier.height(16.dp))
            HPVKnowledgeSection(isYoruba)
        }

        Spacer(modifier = Modifier.height(24.dp))
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
        CounselingFlowScreen()
    }
}
/*
@Composable
fun CervicalCancerInfoScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    val context = LocalContext.current
    val rawId_1 = R.raw.eliminating_cervical_cancer
    val rawId_2 = R.raw.video1


    val uri_1 = Uri.parse("android.resource://${context.packageName}/$rawId_1")
    val uri_2 = Uri.parse("android.resource://${context.packageName}/$rawId_2")

    val articles = listOf(
        ArticleData(
            title = "🚨 Early Signs & Screening:",
            description = "What Every Woman Should Know",
            imageRes = R.drawable.ab3_stretching,
            postDate = "23/12/2021"
        ),
        ArticleData(
            title = "Burden & Prevention",
            description = "Global Overview of Cervical Cancer",
            imageRes = R.drawable.ab6_pre_natal_yoga,
            postDate = "23/12/2021"
        ),

    )

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        androidx.compose.material3.Text(
            text = "Cervical Cancer",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        androidx.compose.material3.Text(
            text = "Cervical cancer is a type of cancer that starts in the cells of the cervix—the lower, narrow end of the uterus that connects to the vagina. It is one of the most preventable and treatable types of cancer when detected early.",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Section(title = "🧬 Cause") {
            androidx.compose.material3.Text(
                text = "The primary cause is persistent infection with high-risk types of human papillomavirus (HPV), especially types 16 and 18. HPV is a common sexually transmitted infection.",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Section(title = "🔍 Development") {
            androidx.compose.material3.Text(
                text = "Cervical cancer usually develops slowly over time:\n\n" +
                        "Normal cervical cells →\n" +
                        "Precancerous changes (cervical intraepithelial neoplasia, CIN) →\n" +
                        "Invasive cancer, if left untreated.",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        Section(title = "⚠️ Symptoms") {
            BulletPoints(
                listOf(
                    "Abnormal vaginal bleeding (e.g., after sex, between periods, post-menopause)",
                    "Unusual vaginal discharge",
                    "Pelvic pain or pain during intercourse"
                )
            )
        }

        Section(title = "🛡️ Prevention") {
            BulletPoints(
                listOf(
                    "HPV vaccination (recommended before sexual activity begins)",
                    "Regular Pap smears and HPV testing (screening can detect precancerous changes)",
                    "Safe sex practices (e.g., condom use)"
                )
            )
        }

        Section(title = "🩺 Treatment") {
            BulletPoints(
                listOf(
                    "Surgery (e.g., hysterectomy)",
                    "Radiation therapy",
                    "Chemotherapy",
                    "Targeted therapy or immunotherapy in advanced stages"
                )
            )
        }
        SectionTitle("\uD83D\uDEE1\uFE0F How often should I screen?")
        BulletPoints(
            listOf(
                "Ages 25–49: every 3 years.",
                "Ages 50–64: every 5 years if previous results were normal.",
                "In Nigeria: once a year is often recommended."
            )
        )

        SectionTitle("\uD83D\uDEE1\uFE0F Where can I go in Osun State?")
        BulletPoints(
            listOf(
                "UNIOSUN Teaching Hospital, Osogbo",
                "State Specialist Hospital, Osogbo",
                "Fountain University Health Centre",
                "Iremide Medical Centre Annex",
                "FOMWAN Secretariat, Ogo-Oluwa"
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Health Tips Articles",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        ArticleCard(
            article = articles[0], onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }
        )

        Spacer(modifier = Modifier.height(8.dp))
        ArticleCard(
            article = articles[1], onItemClicked = { navController.navigate(route = Articles.FirstArticle.name) }
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Health Tips Video",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))

        Spacer(modifier = Modifier.height(16.dp))
        VideoPlayer(context, uri_1)
        Spacer(modifier = Modifier.height(8.dp))

        Spacer(modifier = Modifier.height(16.dp))
        VideoPlayer(context, uri_2)
    }
}*/

@Composable
fun CervicalCancerInfoScreen(
    navController: NavController,
    languageViewModel: LanguageViewModel = hiltViewModel()
) {
    var isYoruba by remember { mutableStateOf(false) }
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Text("English")
            Switch(checked = isYoruba, onCheckedChange = { isYoruba = it })
            Text("Yorùbá")
        }
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




