package com.example.smarthouse_tp3

// import androidx.compose.runtime.MutableState
// import androidx.compose.runtime.mutableStateOf
// import androidx.compose.ui.graphics.Color
// import com.example.smarthouse_tp3.ui.DeviceViewModel
//
//
// class DeviceLight(name: String) : Device(name) {
//     override var deviceType: Type = Type.LIGHT
//     private var hexCode = mutableStateOf("#FF0000")
//
//     abstract var deviceIcon : Int
//
//     override fun getSmallIconsList(): List<Int> {
//         TODO("Not yet implemented")
//     }
//
//     fun changeColor(str : String) {
//         hexCode.value = str
//
//         // changeDeviceIconColor(Color(android.graphics.Color.parseColor(str)))
//     }
//
//     fun getHexCode() : MutableState<String> {
//         return hexCode
//     }
//
//     override fun changeSwitchState() {
//         super.changeSwitchState()
//         if (getSwitchState()) {
//             changeDeviceIconColor(Color.Yellow)
//         }
//         else {
//             changeDeviceIconColor(Color.Black)
//         }
//     }
// }