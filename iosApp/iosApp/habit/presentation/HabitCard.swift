import SwiftUI

struct HabitCard: View {
    @State private var isOn = false
    
    var body: some View {
        ZStack(alignment: Alignment.leading) {
            RoundedRectangle(cornerRadius: 15)
                .fill(.gray)
                .opacity(0.3)
                .shadow(radius: 5)
            
            Toggle(isOn: $isOn) {
                Text("Habit Text")
                    .accessibilityIdentifier("HabitCardText")
            }
            .toggleStyle(iOSCheckboxToggleStyle())
                .padding()
                .font(.title2)
                .foregroundColor(.black)
                .accessibilityIdentifier("HabitCardToggle")
        }
        .frame(width: 350, height: 75)
    }
}


//#Preview
//{
//    HabitCard()
//}
