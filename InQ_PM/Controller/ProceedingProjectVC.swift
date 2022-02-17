//
//  ProceedingProjectVC.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/15.
//

import UIKit
import Alamofire

class ProceedingProjectVC: UIViewController {
    
    var projectManager = ProjectManager()
    
    var projectData : [ProjectData] = []
    
    let refresh = UIRefreshControl()
    
    @IBOutlet weak var mytableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        mytableView.delegate = self
        mytableView.dataSource = self
        // Do any additional setup after loading the view.
        projectManager.delegate = self
        
        self.initRefresh()
    }
    
    @IBAction func joinThisProject(_ sender: UIButton) {
        
    }
    
    
}

//MARK: - ProjectManagerDelegate

extension ProceedingProjectVC : ProjectManagerDelegate {
    func updateProjectList(_ data: [ProjectData]) {
        projectData = data
    }
    
}

//MARK: - UITableViewDelegate, UITableViewDataSource

extension ProceedingProjectVC : UITableViewDelegate, UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let alert = UIAlertController(title: "NOTICE", message: "해당 프로젝트에 등록하시겠습니까?", preferredStyle: UIAlertController.Style.alert)
        let okAction = UIAlertAction(title: "YES", style: .default) { (action) in
            let URL = "https://1af1-115-143-100-251.ngrok.io/members/add-project/\(self.projectData[indexPath.row].id!)"
            AF.request(URL, method: .post).responseJSON { response in
                print("response: \(response)")}.resume() }
        let noAction = UIAlertAction(title: "NO", style: .default, handler: nil)
        alert.addAction(okAction)
        alert.addAction(noAction)
        present(alert, animated: false, completion: nil)
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return projectData.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "joinCell", for: indexPath) as? RecruitTableViewCell else {
            fatalError("No CardTableViewCell for cardCell id")
        }
        
        cell.projectID.text = projectData[indexPath.row].projectName
        cell.detail.text = projectData[indexPath.row].details
        cell.techList.text = projectData[indexPath.row].techList
        
        return cell
    }
}

//MARK: - RefreshControl

extension ProceedingProjectVC {
    func initRefresh() {
        refresh.addTarget(self, action: #selector(refreshTable(refresh:)), for: .valueChanged)
        refresh.backgroundColor = UIColor.clear
        self.mytableView.refreshControl = refresh
    }
    
    @objc func refreshTable(refresh: UIRefreshControl) {
        print("refreshTable")
        projectManager.filteringProject("RECRUIT")
        DispatchQueue.main.asyncAfter(deadline: .now() + 1.0) {
            self.mytableView.reloadData()
            refresh.endRefreshing()
        }
    }
    
    //MARK: - UIRefreshControl of ScrollView
    func scrollViewWillEndDragging(_ scrollView: UIScrollView, withVelocity velocity: CGPoint, targetContentOffset: UnsafeMutablePointer<CGPoint>) {
        if(velocity.y < -0.1) {
            self.refreshTable(refresh: self.refresh)
        }
    }
}
