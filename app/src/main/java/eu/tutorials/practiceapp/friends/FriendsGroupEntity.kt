package eu.tutorials.practiceapp.friends

data class FriendsGroupEntity(
    val groupId: Int,
    val groupName: String,
    val participantsCount: Int,
    val goal: String
)