package com.example.womencare.ui.auth.signup

data class State(val name: String, val cities: List<String>)


val nigeriaStates = listOf(
    State("Abia", listOf("Umuahia", "Aba")),
    State("Adamawa", listOf("Yola", "Mubi")),
    State("Akwa Ibom", listOf("Uyo", "Eket", "Ikot Ekpene")),
    State("Anambra", listOf("Awka", "Onitsha", "Nnewi")),
    State("Bauchi", listOf("Bauchi", "Azare", "Misau")),
    State("Bayelsa", listOf("Yenagoa", "Brass")),
    State("Benue", listOf("Makurdi", "Otukpo", "Gboko")),
    State("Borno", listOf("Maiduguri", "Biu", "Monguno")),
    State("Cross River", listOf("Calabar", "Ikom", "Ugep")),
    State("Delta", listOf("Asaba", "Warri", "Sapele", "Ughelli", "Agbor")),
    State("Ebonyi", listOf("Abakaliki", "Afikpo")),
    State("Edo", listOf("Benin City", "Auchi", "Ekpoma")),
    State("Ekiti", listOf("Ado-Ekiti", "Ikere", "Ijero")),
    State("Enugu", listOf("Enugu", "Nsukka", "Agbani")),
    State("FCT", listOf("Abuja", "Gwagwalada", "Kubwa")),
    State("Gombe", listOf("Gombe", "Kaltungo", "Dukku")),
    State("Imo", listOf("Owerri", "Orlu", "Okigwe")),
    State("Jigawa", listOf("Dutse", "Hadejia", "Gumel")),
    State("Kaduna", listOf("Kaduna", "Zaria", "Kafanchan", "Saminaka")),
    State("Kano", listOf("Kano", "Wudil", "Rano", "Dambatta")),
    State("Katsina", listOf("Katsina", "Daura", "Funtua")),
    State("Kebbi", listOf("Birnin Kebbi", "Argungu", "Yauri")),
    State("Kogi", listOf("Lokoja", "Okene", "Idah")),
    State("Kwara", listOf("Ilorin", "Offa", "Jebba")),
    State("Lagos", listOf("Ikeja", "Lagos Island", "Ikorodu", "Badagry", "Epe")),
    State("Nasarawa", listOf("Lafia", "Keffi", "Akwanga")),
    State("Niger", listOf("Minna", "Suleja", "Bida", "Kontagora")),
    State("Ogun", listOf("Abeokuta", "Ijebu-Ode", "Sagamu", "Ota")),
    State("Ondo", listOf("Akure", "Ondo Town", "Owo", "Ikare")),
    State("Osun", listOf("Osogbo", "Ile-Ife", "Ilesa")),
    State("Oyo", listOf("Ibadan", "Ogbomoso", "Iseyin", "Oyo Town")),
    State("Plateau", listOf("Jos", "Pankshin", "Shendam")),
    State("Rivers", listOf("Port Harcourt", "Bonny", "Omoku", "Eleme")),
    State("Sokoto", listOf("Sokoto", "Tambuwal", "Wurno")),
    State("Taraba", listOf("Jalingo", "Wukari", "Gembu")),
    State("Yobe", listOf("Damaturu", "Potiskum", "Gashua")),
    State("Zamfara", listOf("Gusau", "Kaura Namoda", "Anka"))
)

