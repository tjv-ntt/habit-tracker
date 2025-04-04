// HomeViewModel.swift
import Foundation
import Combine
import Shared

class HomeViewModel: ObservableObject {
    @Published var allHabits: [Shared.Habit] = []
    
    private let getAllHabitsUseCase: GetAllHabitsUseCase
    private let upsertHabitUseCase: UpsertHabitUseCase
    private let deleteHabitUseCase: DeleteHabitUseCase
    // let habitRepository: HabitRepository
    
    init(getAllHabitsUseCase: GetAllHabitsUseCase, upsertHabitUseCase: UpsertHabitUseCase, deleteHabitUseCase: DeleteHabitUseCase) {
        //  habitRepository: HabitRepository = HabitRepositoryHelper().getHabitRepository()
        
        self.getAllHabitsUseCase = getAllHabitsUseCase
        self.upsertHabitUseCase = upsertHabitUseCase
        self.deleteHabitUseCase = deleteHabitUseCase
        //    self.habitRepository = habitRepository
    }
    
    @MainActor
    func getAllHabits() async {
        do {
            let habits = try await getAllHabitsUseCase.execute()
            self.allHabits = habits
        } catch {
            print("Failed to fetch habits: \(error)")
        }
    }
    
    @MainActor
    func upsertHabit(habit: Shared.Habit) async {
        do {
            //TODO: add if statement to check getAllHabits?
            try await upsertHabitUseCase.execute(habit: habit)
            await getAllHabits()
        } catch {
            print("Failed to upsert habit: \(error)")
        }
    }
    
    
    @MainActor
    func deleteHabit(habit: Shared.Habit) async {
        do {
            // Call the deleteHabitUseCase to delete the habit
            try await deleteHabitUseCase.execute(habit: habit)
            // Refresh the list of habits after deletion
            await getAllHabits()
        } catch {
            print("Failed to delete habit: \(error)")
        }
        
    }
}
