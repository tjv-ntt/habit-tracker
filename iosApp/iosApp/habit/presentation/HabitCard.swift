import SwiftUI

struct HabitCard: View {
    @State private var isOn = false
    var habit: HabitWrapper
    var onDelete: () -> Void

    var body: some View {
        HStack {
            ZStack(alignment: Alignment.leading) {
                RoundedRectangle(cornerRadius: 15)
                    .fill(.gray)
                    .opacity(0.3)
                    .shadow(radius: 5)
                    .frame(width: 350, height: 75)

                Toggle(isOn: $isOn) {
                    Text(habit.habit.name)
                        .accessibilityIdentifier("HabitCardText")
                }
                .toggleStyle(iOSCheckboxToggleStyle())
                .padding()
                .font(.title2)
                .foregroundColor(.black)
                .accessibilityIdentifier("HabitCardToggle")
            }
            Spacer()
            //TODO: refactor to open a dialog box
            //TODO: resize selection area of deletion button so the dialog box only opens when the delete button is clicked
            Button(action: onDelete) {
                Image(systemName: "trash.circle.fill").font(.system(size: 30))
            }
            .accessibilityIdentifier("DeleteHabitButton")
        }
    }
}

//#Preview
//{
//    HabitCard()
//}
