package jp.playing.table.pokerdata

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class Player : RealmObject(), Serializable {
    var game_id = 0
    var p1 = ""
    var p2 = ""
    var p3 = ""
    var p4 = ""
    var p5 = ""
    var p6 = ""
    var p7 = ""
    var p8 = ""
    var p9 = ""
    var p10 = ""

    @PrimaryKey
    var id: Int = 0
}