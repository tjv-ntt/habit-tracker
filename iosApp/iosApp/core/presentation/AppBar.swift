import Foundation
import Shared
import SwiftUI

typealias Habit = Shared.Habit

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
      //      Spacer()

            HStack {
                Spacer()
                Button(action: {
                    isPresentingModal = true
                }) {
                    Text("Add Habit")
                        .frame(width: 100)
                        .lineLimit(1)
                        .truncationMode(.tail)
                }
                .sheet(isPresented: $isPresentingModal) {
                    AddHabitView(isPresented: $isPresentingModal) { newHabit in
                        Task {
                            await viewModel.upsertHabit(habit: newHabit)
                        }
                    }
                }
            }
        }
    }
}

struct AddHabitView: View {
    @State private var habit = Shared.Habit(
        id: generateInt32FromUUID(), name: "", completed: false)
    @State private var habitName: String = ""
    @Binding var isPresented: Bool

    var onSubmit: (Shared.Habit) -> Void

    var body: some View {
        Text("Add Habit")
        VStack {
            TextField(
                "Enter Habit Name",
                text: $habitName)
            
            .padding()
            .textFieldStyle(RoundedBorderTextFieldStyle())
            HStack {
                Button("Cancel") {
                    isPresented = false
                }
                .padding()
                Button("Submit") {
                    let newHabit = Shared.Habit(id: habit.id, name: habitName, completed: habit.completed)
                    onSubmit(newHabit)
                    isPresented = false
                }
                .padding()
            }
        }
        .padding()
    }
}

func generateInt32FromUUID() -> Int32 {
    let uuid = UUID()
    let uuidString = uuid.uuidString
    let hashValue = uuidString.hashValue
    return Int32(truncatingIfNeeded: hashValue)
}

