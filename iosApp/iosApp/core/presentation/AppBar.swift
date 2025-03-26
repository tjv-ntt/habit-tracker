import SwiftUI
import Shared

struct AppBar: View {
    @StateObject var viewModel: HomeViewModel
    @State private var isPresentingModal = false

    var body: some View {
        NavigationView {
            HabitCardList(viewModel: viewModel)
                .toolbar {
                   ToolbarItem(placement: .principal) {
                       Text("Habit Tracker")
                           .font(.title)
                   }
               }
        }
        VStack {
            Spacer()

            HStack {
                Spacer()
                Button(action: {
                    isPresentingModal = true
                }) {
                    Text("Add Habit")
                        .frame(
                            width: 100
                        )
                        .lineLimit(1)
                        .truncationMode(.tail)
                }
               .sheet(isPresented: $isPresentingModal) {
                   AddHabitView(isPresented: $isPresentingModal) { newHabit in
                       viewModel.upsertHabit(habit: newHabit)
                   }
               }
            }
        }

    }
}

struct AddHabitView: View {
    @State private var habit = Shared.Habit(id: 1, name: "", completed: false)
    @Binding var isPresented: Bool
    
    var onSubmit: (Shared.Habit) -> Void
    
    var body: some View {
        Text("Add Habit")
        VStack{
            TextField("Enter Habit Name", text: $habit.name)
                .padding()
                .textFieldStyle(RoundedBorderTextFieldStyle())
            HStack {
                           Button("Cancel") {
                               isPresented = false
                           }
                           .padding()
                           Button("Submit") {
                               onSubmit(habit)
                               isPresented = false
                               
                           }
                           .padding()
                       }
                   }
                   .padding()
               }
           }
