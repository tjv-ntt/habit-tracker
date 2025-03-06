import SwiftUI

struct HabitCard: View {
    @State private var isOn = false
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .fill(.white)
                .shadow(radius: 10)
            
            HStack{
                Toggle(isOn: $isOn) {
                            Text("Habit Text")
                        }
                .toggleStyle(iOSCheckboxToggleStyle())
            }
        }
        .frame(width: 350, height: 100)
    }
}

