package jp.playing.table.pokerdata

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

class User : RealmObject(), Serializable {
    var name: String = "" //他のプレーヤーの名前

    @PrimaryKey
    var id: Int = 0
}