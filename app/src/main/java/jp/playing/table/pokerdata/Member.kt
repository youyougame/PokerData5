package jp.playing.table.pokerdata

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class Member: RealmObject(), Serializable {
    var memberName = "" // 参加中のメンバーの名前
    var memberRound = 0 //参加中のメンバーの順番
    var game_id = "" //テーブルのid
    var hand_count = 0 //ゲーム数
    var memberChips = 0 //プレイヤーのチップ数

    @PrimaryKey
    var id: Int = 0
}