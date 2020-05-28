package jp.playing.table.pokerdata

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class Turn : RealmObject(), Serializable {
    var game_id: Int = 0
    var count: Int = 0 // ゲーム数
    var round: String = "" //プリフロップ等のラウンド
    var round_count: Int = 0 //ラウンド内での週数
    var player: String = "" // プレイヤー名
    var chip: Int = 0 // プレイされたチップ

    @PrimaryKey
    var id: Int = 0
}