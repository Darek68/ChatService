
val names:MutableList<Name> = mutableListOf(
    Name(1,"Вася Пупкин"),
    Name(2,"Иван Сидоров"),
    Name(3,"Сергей Иванов"),
    Name(4,"Марфа Василева"),
    Name(5,"Мария Петровна"))

fun main() {
    val chatService = ChatsService()

    println(chatService.addMes(1,true,"Моя первая реплика товарищю"))



}

class Name (val id: Int,val name: String){ // собеседники

}

class Message(
    var id:Int,          // идентификатор сообщения
    val myReply:Boolean, // это моя реплика\собеседника
    val mes:String,      // сообщение
    var read:Boolean,    // прочитано
    var del:Boolean)

class Chat (val id: Int, // идентификатор собеседника
            var messages: MutableList<Message>){

    fun add(message: Message): Int {
        message.id = this.messages.size
        this.messages.add(message)
        return this.messages.last().id
    }
}

class ChatsService (){

    var chats:MutableList<Chat> = mutableListOf()

    fun getName(nameId:Int): String? {
        return names.findLast { it.id == nameId}?.name
    }

    fun findChat(chatId: Int?):Chat?{ //for (note in notes)
        return chats.findLast { it.id == chatId }
    }

    fun addMes(id:Int?,myReply:Boolean,mes:String): String{ //val l = b?.length ?: -1
        if (id == null) return "Не указан id чата"
        val chat = findChat(id) ?: Chat(id,ArrayList()) //Chat(id,ArrayList()).also { chat = it }
        val mesId = chat.add(Message(0,myReply,mes,myReply,false))
        return "К чату с пользователем ${getName(id)} добавлно сообщение с идентификатором ${mesId}"
    }

}
