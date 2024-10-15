import QtQuick

Window {
    width: 640
    height: 480
    visible: true
    title: qsTr("Hello World")

    Rectangle {
        id: rect
        color: "blue"
        width: parent.width
        height: parent.height
    }
}
