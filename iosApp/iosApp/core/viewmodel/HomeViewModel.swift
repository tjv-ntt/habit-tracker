// HomeViewModel.swift
import Foundation
import Combine
import Shared

class HomeViewModel: ObservableObject {
    @Published var allHabits: [Shared.Habit] = []
    
    private let getAllHabitsUseCase: GetAllHabitsUseCase
    private let upsertHabitUseCase: UpsertHabitUseCase
    // let habitRepository: HabitRepository
    
    init(getAllHabitsUseCase: GetAllHabitsUseCase, upsertHabitUseCase: UpsertHabitUseCase) {
        //  habitRepository: HabitRepository = HabitRepositoryHelper().getHabitRepository()
        
        self.getAllHabitsUseCase = getAllHabitsUseCase
        self.upsertHabitUseCase = upsertHabitUseCase
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
}
