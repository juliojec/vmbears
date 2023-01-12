import { Component } from '@angular/core';
import { UploadService } from './services/upload.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [UploadService]
})
export class AppComponent {

  title = 'frontend';
  filesToByteArray: any[] = [];
  loading = false;
  file: any;

  constructor(private uploadService: UploadService) {}

  prepareFile(event: any): void {
    const doc: any = document;
    this.file = doc.querySelector('input[type=file]').files[0];

    if (this.file) {
        const reader = new FileReader();
        reader.onload = (e): void => {
            this.filesToByteArray.push({ blob: reader.result, data: this.file });
        };
        reader.readAsDataURL(this.file);
        this.save();
    }
  }

  save(): void {
    this.loading = true;
    this.uploadService.save(this.file).subscribe(() => {
        this.loading = false;
    });
  }

  compareObjectsById(o1: any, o2: any): boolean {
      return o1?.id === o2?.id;
  }

  openFile(file: { data: BlobPart; type: any; }): void {
      let blob = new Blob([file.data], { type: file.type });
      let url = window.URL.createObjectURL(blob);
      window.open(url, '_blank');
  }

  formatBytes(bytes: number, decimals = 2) {
    if (bytes === 0) return '0 Bytes';

    const k = 1024;
    const dm = decimals < 0 ? 0 : decimals;
    const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];

    const i = Math.floor(Math.log(bytes) / Math.log(k));

    return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
  }
}
